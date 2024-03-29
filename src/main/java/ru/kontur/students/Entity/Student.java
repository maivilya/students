package ru.kontur.students.Entity;

import lombok.Data;

@Data
public class Student {

    private static int currentId;
    private int id;
    private String name;
    private String groupName;

    static {
        currentId = 1;
    }

    public Student(String name, String groupName) {
        id = currentId++;
        this.name = name;
        this.groupName = groupName;
    }
}
