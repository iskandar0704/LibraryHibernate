package com.example.controller;

import com.example.dto.StudentBook;
import com.example.repository.StudentBookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/studentBook")
public class StudentBookController {
    private StudentBookRepository studentBookRepository = new StudentBookRepository();

    @PostMapping("/")
    public StudentBook createStudentBook(@RequestBody StudentBook studentBook){
        studentBook.setId(UUID.randomUUID().toString());
        studentBookRepository.addStudentBook(studentBook);
        return studentBook;
    }

    @GetMapping("/")
    public List<StudentBook> getStudentBookList(){
        return studentBookRepository.getStudentBookList();
    }

    @GetMapping("/{id}")
    public StudentBook getStudentBookById(@PathVariable String id){
        return studentBookRepository.getStudentBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentBookById(@PathVariable String id){
        studentBookRepository.deleteStudentBookById(id);
    }

    @PutMapping("/{id}")
    public void updateStudentBookById(@PathVariable String id, @RequestBody StudentBook studentBook){
        studentBookRepository.updateStudentBookById(id,studentBook);
    }

}
