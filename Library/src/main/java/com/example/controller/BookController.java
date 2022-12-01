package com.example.controller;

import com.example.dto.Book;
import com.example.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    private BookRepository bookRepository = new BookRepository();

    @PostMapping("/")
    public ResponseEntity<?> createBook(@RequestBody Book book){
//        ResponseEntity<Book> responseEntity = new ResponseEntity<>(book, HttpStatus.OK);

        bookRepository.addBook(book);
        return ResponseEntity.ok(book);


//        return ResponseEntity.ok(book);

    }

    @GetMapping("/")
    public List<Book> getBookList(){
        return bookRepository.getBookList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id){
        Book book = bookRepository.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id){
        bookRepository.deleteBookById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable String id, @RequestBody Book book){
        bookRepository.updateBookById(id,book);
        return ResponseEntity.ok().build();
    }


}