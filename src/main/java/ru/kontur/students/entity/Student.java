package ru.kontur.students.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String name;

    @Column()
    private String groupName;

    @Column()
    private String password;

    @Column()
    private String role;

    public Student() {

    }

    public Student(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }
}
