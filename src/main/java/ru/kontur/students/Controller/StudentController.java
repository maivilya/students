package ru.kontur.students.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kontur.students.Service.StudentService;

@Controller
@RequestMapping("/users")
@Slf4j
public class StudentController {
/*
    private final StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("studentTable", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("{id}")
    public String user(@PathVariable int id, Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "studentProfile";
    }

    @GetMapping("/group/{groupName}")
    public String group(@PathVariable String groupName, Model model) {
        model.addAttribute("groupTable", studentService.getStudentsByGroup(groupName));
        return "groups";
    }*/
}
