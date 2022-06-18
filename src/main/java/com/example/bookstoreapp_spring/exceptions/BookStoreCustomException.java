package com.example.bookstoreapp_spring.exceptions;

public class BookStoreCustomException extends RuntimeException{
    public BookStoreCustomException(String message) {
        super(message);
    }
}