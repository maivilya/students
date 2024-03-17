package ru.kontur.students.Repository;

import org.springframework.stereotype.Repository;
import ru.kontur.students.Entity.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        initialization();
    }

    /**
     * Метод возвращает список всех студентов
     * @return Копия списка студентовц
     */
    public List<Student> getAllStudents() {
        return List.copyOf(students);
    }

    /**
     * Первоначальная инициализация списка студентов
     */
    private void initialization() {
        students.add(new Student("Илья", "A1"));
        students.add(new Student("Нияз", "A1"));
        students.add(new Student("Евгений", "B2"));
        students.add(new Student("Алексей", "A1"));
        students.add(new Student("Кристина", "C1"));
        students.add(new Student("Максим", "C1"));
        students.add(new Student("Артем", "A1"));
        students.add(new Student("Илья", "C3"));
        students.add(new Student("Евгений", "C3"));
    }
}
