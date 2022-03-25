package com.intervale.cources.library.exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException{
    private Integer id;
    public BookNotFoundException(Integer id) {
        super(String.format("Book is not found with id : '%s'", id));
    }
}
