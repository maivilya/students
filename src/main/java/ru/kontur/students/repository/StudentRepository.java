package ru.kontur.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kontur.students.entity.Student;
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
     * Метод возвращает студента по уникальному идентификатору
     *
     * @param id Идентификатор студента
     * @return Если студент с таким id существует, то вернется объект студента,
     * иначе вернется null
     */
    Student getStudentById(int id);

    /**
     * Метод возвращает студента по уникальному идентификатору
     *
     * @param studentName Имя студента
     * @return Если студент с таким именем существует, то вернется объект студента,
     * иначе вернется null
     */
    Student getStudentByName(String studentName);


    /**
     * Метод возвращает список студентов по имени
     *
     * @param studentName Имя студента
     * @return Список студентов с заданным именем
     */
    List<Student> getStudentsByName(String studentName);

    /**
     * Метод возвращает список студентов из определенной группы
     *
     * @param groupName Название группы, по которой будут искаться студенты
     * @return Все студенты из заданной группы
     */
    List<Student> getStudentsByGroupName(String groupName);
}
