package ru.kontur.students.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Имя")
    private String name;

    @Column(name = "Группа")
    private String groupName;

    public Student() {

    }

    public Student(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }
}
