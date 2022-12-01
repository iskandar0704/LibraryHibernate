package com.example.controller;

import com.example.exception.BookCreationException;
import com.example.exception.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({ItemNotFoundException.class})
    public ResponseEntity<?> handle(ItemNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({BookCreationException.class})
    public ResponseEntity<?> handle(BookCreationException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    /*@ExceptionHandler({ItemNotFoundException.class,BookCreationException.class})
    public ResponseEntity<?> handle(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }*/
}
