package com.intervale.cources.library.config;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
