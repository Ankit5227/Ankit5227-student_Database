package com.student.demo.studentService;

import com.student.demo.entities.Student;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public List<Student> getStudentsBetween18And25();

    public Student updateStudentAge(Long id);
}
