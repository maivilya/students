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

    public boolean addStudent(Student student) {
        if (!studentRepository.addStudent(student)) {
            log.info("Не удалось добавить студента={}", student);
            throw new NullPointerException("Не удалось добавить студента=" + student);
        }
        log.info("Студент={} добавлен в репозиторий",student);
        return true;
    }

    public Student getStudentById(int id) {
        if (studentRepository.getStudentById(id) == null) {
            log.info("Не удалось найти студента с id={}", id);
            throw new NoSuchElementException("Не удалось найти студента с id=" + id);
        }
        return studentRepository.getStudentById(id);
    }

    public List<Student> getStudentsByName(String studentName) {
        if (studentRepository.getStudentsByName(studentName) == null) {
            log.info("Не удалось найти студентов с именем={}", studentName);
            throw new NoSuchElementException("Не удалось найти студентов с именем=" + studentName);
        }
        return studentRepository.getStudentsByName(studentName);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public List<Student> getStudentsByGroup(String groupName) {
        if (studentRepository.getStudentsByGroup(groupName) == null) {
            log.info("Не удалось найти ни одного студента из группы={}", groupName);
            throw new NoSuchElementException("Не удалось найти ни одного студента из группы=" + groupName);
        }
        return studentRepository.getStudentsByGroup(groupName);
    }
}
