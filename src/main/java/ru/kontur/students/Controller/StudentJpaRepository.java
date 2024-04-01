package ru.kontur.students.Controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kontur.students.Entity.Student;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

}
