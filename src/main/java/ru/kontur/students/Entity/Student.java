package ru.kontur.students.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {

    private static int currentId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String groupName;

    static {
        currentId = 1;
    }

    public Student() {

    }

    public Student(String name, String groupName) {
        id = currentId++;
        this.name = name;
        this.groupName = groupName;
    }
}
