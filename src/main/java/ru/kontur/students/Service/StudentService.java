package ru.kontur.students.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kontur.students.Entity.Student;
import ru.kontur.students.Repository.StudentRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService() {
        studentRepository = new StudentRepository();
    }

    public Student deleteStudentById(int id) {
        Student oldStudent = studentRepository.deleteStudentById(id);
        if (oldStudent == null) {
            log.info("Не удалось удалить студента с id={}", id);
            throw new NullPointerException("Не удалось удалить студента с id=" +  id);
        }
        log.info("Студент с id={} успешно удален", id);
        return oldStudent;
    }

    public Student updateStudent(int id, Student student) {
        if (studentRepository.updateStudent(id, student) == null) {
            log.info("Не удалось обновить данные о студента с id={}, student={}", id, student);
            return null;
        }
        log.info("Данные о студента c id={} успешно обновлены. Новые данные={}", id, student);
        return student;
    }

    public boolean addStudent(Student student) {
        if (!studentRepository.addStudent(student)) {
            log.info("Не удалось добавить студента={}", student);
            return false;
        }
        log.info("Студент={} добавлен в репозиторий",student);
        return true;
    }

    public Student getStudentById(int id) {
        if (studentRepository.getStudentById(id) == null) {
            log.info("Не удалось найти студента с id={}", id);
            throw new NoSuchElementException("Не удалось найти студента с id=" + id);
        }
        log.info("Информация о студенте с id={} успешно выдана", id);
        return studentRepository.getStudentById(id);
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
        return studentRepository.getAllStudents();
    }

    public List<Student> getStudentsByGroup(String groupName) {
        if (studentRepository.getStudentsByGroup(groupName) == null) {
            log.info("Не удалось найти ни одного студента из группы={}", groupName);
            throw new NoSuchElementException("Не удалось найти ни одного студента из группы=" + groupName);
        }
        log.info("Информация о студентах из группы={} успешно выдана", groupName);
        return studentRepository.getStudentsByGroup(groupName);
    }
}
