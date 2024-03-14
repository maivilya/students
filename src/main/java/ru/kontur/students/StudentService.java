package ru.kontur.students;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
        initialization();
    }

    /**
     * Получение студента по уникальному идентификатору
     * @param id Идентификатор студента
     * @return Если студент с таким id существует, то вернется объект студента,
     * иначе вернется null
     */
    public Student getStudent(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Получение студента по его имени
     * @param studentName Имя студента
     * @return Если студент с таким именем существует, то вернется объект студента,
     * иначе вернется null
     */
    public Student getStudent(String studentName) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(studentName))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод возвращает список всех студентов
     * @return Копия списка студентовц
     */
    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    /**
     * Метод возвращает список студентов из определенной группы
     * @param groupName Название группы, по которой будут искаться студенты
     * @return Все студенты из заданной группы
     */
    public List<Student> getStudents(String groupName) {
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
    }
}
