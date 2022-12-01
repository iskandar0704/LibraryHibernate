package com.example.controller;

import com.example.dto.Student;
import com.example.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentRepository studentRepository = new StudentRepository();

    @PostMapping("/")
    public Student createStudent(@RequestBody Student student){
        student.setId(UUID.randomUUID().toString());
        studentRepository.addStudent(student);
        return student;
    }

    @GetMapping("/")
    public List<Student> getStudentList(){
        return studentRepository.getStudentList();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentRepository.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable String id){
        studentRepository.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public void updateStudentById(@PathVariable String id, @RequestBody Student student){
        studentRepository.updateStudentById(id,student);
    }
}
