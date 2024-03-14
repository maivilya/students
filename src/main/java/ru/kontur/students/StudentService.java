package ru.kontur.students;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class StudentService {

    private final List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
        initialization();
    }

    /**
     * Получение студента по уникальному идентификатору
     * @param id идентификатор
     * @return если студент с таким id существует, то вернется объект студента,
     * иначе вернется null
     */
    public Student getStudent(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
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
    }
}
