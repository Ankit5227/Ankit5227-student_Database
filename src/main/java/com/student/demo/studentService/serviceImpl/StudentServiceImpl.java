package com.student.demo.studentService.serviceImpl;

import com.student.demo.entities.Student;
import com.student.demo.studentRepository.StudentRepository;
import com.student.demo.studentService.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public Student saveStudent(Student student) {
        student.setAge(student.calculateAge());
        return studentRepo.save(student);
    }
    @Override
    public List<Student> getAllStudents()  {
            return studentRepo.findAll();
    }

    @Override
    public List<Student> getStudentsBetween18And25(){
        return studentRepo.findByAgeBetween(18, 25);
    }

    @Override
    public Student updateStudentAge(Long id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setAge(student.calculateAge());
        return studentRepo.save(student);
    }
}
