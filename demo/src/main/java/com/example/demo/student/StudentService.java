package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void addNewStudent(Student student) {
        //Optional<Student> studentByEmail = studentRepo.findStudentByEmail(student.getEmail());
        Optional<Student> studentOptional=
                studentRepo.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        studentRepo.save(student);
        //System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exits=studentRepo.existsById(studentId);
        if (!exits){
            throw new IllegalStateException("Student with ID = " +studentId+" does not exists");
        }
        studentRepo.deleteById(studentId);
    }
}
