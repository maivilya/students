package ru.kontur.students.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kontur.students.entity.Student;
import ru.kontur.students.service.StudentService;
import java.util.List;
import java.util.NoSuchElementException;

@RestController()
@RequestMapping("/student")
@Slf4j
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable int id) {
        log.info("Поступил запрос на удаление студента с id={}", id);
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentService.deleteStudentById(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Boolean> addStudent(@RequestBody Student student) {
        log.info("Поступил запрос на добавление студента={}", student);
        if (student != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentService.addStudent(student));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        log.info("Поступил запрос на выдачу информации о студенте с id={}", id);
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentService.getStudentById(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        log.info("Поступил запрос на выдачу информации обо всех студентах");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.getAllStudents());
    }


    @GetMapping("search")
    public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String studentName) {
        log.info("Поступил запрос на выдачу информации обо всех студентах c именем={}", studentName);
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentService.getStudentsByName(studentName));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/group/{groupName}")
    public ResponseEntity<List<Student>> getStudentsByGroup(@PathVariable String groupName) {
        log.info("Поступил запрос на выдачу информации обо всех студентах из группы={}", groupName);
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentService.getStudentsByGroupName(groupName));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    //region test mapping
    @GetMapping("user")
    public String user() {
        return "user";
    }

    @GetMapping("admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("any")
    public String any() {
        return "any";
    }
}
