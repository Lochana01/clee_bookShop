package com.example.Clee.exception;

public class BookSaveException extends RuntimeException{

    public BookSaveException(String message, Throwable cause){
        super(message,cause);
    }
}
