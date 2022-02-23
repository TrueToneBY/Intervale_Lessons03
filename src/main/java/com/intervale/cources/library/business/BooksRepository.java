package com.intervale.cources.library.business;

import com.intervale.cources.library.model.Books;
import com.intervale.cources.library.model.BooksDto;

import java.util.List;

public interface BooksRepository<k> {

    boolean saveBooks  (Books books);

    Integer updateBooks(Books books);

    BooksDto findBooksById(Integer id);

    List<BooksDto> findByAuthor(String author);

    List<BooksDto> findByName(String name);

    List<BooksDto> findByIsbn(String isbn);

    Integer deleteBooksById(Integer id);

    List<BooksDto> getBook();

}
