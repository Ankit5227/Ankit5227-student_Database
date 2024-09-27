package com.student.demo.studentController;

import com.student.demo.entities.Student;
import com.student.demo.studentService.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/between-18-25")
    public ResponseEntity<List<Student>> getStudentsBetween18And25() {
        List<Student> students = studentService.getStudentsBetween18And25();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/update_age/{id}")
    public ResponseEntity<Student> updateStudentAge(@PathVariable long id) {
        Student updatedStudent = studentService.updateStudentAge(id);
        return ResponseEntity.ok(updatedStudent);
    }
}
