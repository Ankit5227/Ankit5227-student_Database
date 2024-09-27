package com.student.demo.studentRepository;

import com.student.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAgeBetween(int minAge, int maxAge);
}