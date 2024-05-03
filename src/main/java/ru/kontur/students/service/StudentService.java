package ru.kontur.students.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.kontur.students.entity.Student;
import ru.kontur.students.repository.StudentRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student deleteStudentById(int id) {
        Student oldStudent = studentRepository.deleteStudentById(id);
        if (oldStudent == null) {
            log.info("Не удалось удалить студента с id={}", id);
            throw new NoSuchElementException("Не удалось удалить студента с id=" + id);
        }
        log.info("Студент с id={} успешно удален", id);
        return oldStudent;
    }

    public boolean addStudent(Student student) {
        studentRepository.save(student);
        log.info("Студент={} добавлен в репозиторий", student);
        return true;
    }

    public Student getStudentById(int id) {
        if (studentRepository.getStudentById(id) == null) {
            log.info("Не удалось найти студента с id={}", id);
            throw new NoSuchElementException("Не удалось найти студента с id=" + id);
        }
        log.info("Информация о студенте с id={} успешно выдана", id);
        return studentRepository.findById(id).get();
    }

    public List<Student> getStudentsByName(String studentName) {
        if (studentRepository.getStudentsByName(studentName) == null) {
            log.info("Не удалось найти студентов с именем={}", studentName);
            throw new NoSuchElementException("Не удалось найти студентов с именем=" + studentName);
        }
        log.info("Информация о студентах с именем={} успешно выдана", studentName);
        return studentRepository.getStudentsByName(studentName);
    }

    public List<Student> getAllStudents() {
        log.info("Информация о студентах успешно выдана");
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByGroupName(String groupName) {
        if (studentRepository.getStudentsByGroupName(groupName) == null) {
            log.info("Не удалось найти ни одного студента из группы={}", groupName);
            throw new NoSuchElementException("Не удалось найти ни одного студента из группы=" + groupName);
        }
        log.info("Информация о студентах из группы={} успешно выдана", groupName);
        return studentRepository.getStudentsByGroupName(groupName);
    }

    @EventListener(ContextRefreshedEvent.class)
    private void initializeStartData() {
        Student usualStudent = new Student("Обычный студент", "7Б");
        usualStudent.setRole("usualStudent");
        usualStudent.setPassword("usualStudentPassword");
        studentRepository.save(usualStudent);

        Student admin = new Student("Студент-администратор", "9Д");
        admin.setRole("admin");
        admin.setPassword("adminPassword");
        studentRepository.save(admin);
    }
}
