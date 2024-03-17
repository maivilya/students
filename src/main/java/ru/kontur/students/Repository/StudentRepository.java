package ru.kontur.students.Repository;

import org.springframework.stereotype.Repository;
import ru.kontur.students.Entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        initialization();
    }

    /**
     * Метод возвращает студента по уникальному идентификатору
     * @param id Идентификатор студента
     * @return Если студент с таким id существует, то вернется объект студента,
     * иначе вернется null
     */
    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод возвращает список студентов по имени
     * @param studentName Имя студента
     * @return Список студентов с заданным именем
     */
    public List<Student> getStudentsByName(String studentName) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(studentName))
                .collect(Collectors.toList());
    }

    /**
     * Метод возвращает список всех студентов
     * @return Копия списка студентов
     */
    public List<Student> getAllStudents() {
        return List.copyOf(students);
    }

    /**
     * Метод возвращает список студентов из определенной группы
     * @param groupName Название группы, по которой будут искаться студенты
     * @return Все студенты из заданной группы
     */
    public List<Student> getStudentsByGroup(String groupName) {
        return students.stream()
                .filter(s -> s.getGroupName().equalsIgnoreCase(groupName))
                .collect(Collectors.toList());
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
