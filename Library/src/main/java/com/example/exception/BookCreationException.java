package com.example.exception;

public class BookCreationException extends RuntimeException{
    public BookCreationException(String message) {
        super(message);
    }
}
