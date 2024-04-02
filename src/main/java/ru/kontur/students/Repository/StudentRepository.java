package ru.kontur.students.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kontur.students.Entity.Student;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     * Метод удаляет сдуента по идентификатору
     * @param id Идентификатор студента
     * @return Удаленного(старого студента) студента
     */
    Student deleteStudentById(int id);

    /**
     * Метод заменяет объект студента по уникальному идентификатору
     * @param id      Идентификатор студента
     * @param student Новый объект студента
     * @return        Объект нового студента, которого добавили в репозиторий
     */
    Student updateStudentById(int id, Student student);

    /**
     * Метод добавляет студента в репозиторий
     * @param student Объект студента
     * @return если студента получилось добавить - true, иначе - false
     */
    boolean addStudent(Student student);

    /**
     * Метод возвращает студента по уникальному идентификатору
     *
     * @param id Идентификатор студента
     * @return Если студент с таким id существует, то вернется объект студента,
     * иначе вернется null
     */
    Student getStudentById(int id);


    /**
     * Метод возвращает список студентов по имени
     *
     * @param studentName Имя студента
     * @return Список студентов с заданным именем
     */
    List<Student> getStudentsByName(String studentName);

    /**
     * Метод возвращает список всех студентов
     *
     * @return Копия списка студентов
     */
    List<Student> getAllStudents();

    /**
     * Метод возвращает список студентов из определенной группы
     *
     * @param groupName Название группы, по которой будут искаться студенты
     * @return Все студенты из заданной группы
     */
    List<Student> getStudentsByGroup(String groupName);
}
