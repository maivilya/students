package ru.kontur.students;

import org.springframework.web.bind.annotation.RestController;

@RestController()
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
