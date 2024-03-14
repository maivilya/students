package ru.kontur.students;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class StudentService {

    private final List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }
}
