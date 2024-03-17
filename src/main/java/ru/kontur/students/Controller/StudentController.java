package ru.kontur.students.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kontur.students.Entity.Student;
import ru.kontur.students.Service.StudentService;

import java.util.List;

@RestController()
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/search")
    public List<Student> getStudentsByName(@RequestParam String studentName) {
        return studentService.getStudentsByName(studentName);
    }

    @GetMapping("/group/{groupName}/student")
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return studentService.getStudents(groupName);
    }
}
