package ru.kontur.students.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kontur.students.Service.StudentService;

@Controller
@RequestMapping("/users")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("studentTable", studentService.getAllStudents());
        return "students";
    }
}
