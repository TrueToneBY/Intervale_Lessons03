package com.intervale.cources.library.business;


import com.intervale.cources.library.external.alfabank.model.BookWithCurrencies;
import com.intervale.cources.library.external.alfabank.model.BookWithCurrencyRange;
import com.intervale.cources.library.model.Books;
import com.intervale.cources.library.model.BooksDto;

import java.awt.print.Book;
import java.util.List;

public interface BooksRepository<k> {

    boolean saveBooks  (Books books);

    Integer updateBooks(BooksDto books);

    BooksDto findBooksById(Integer id);

    List<BooksDto> findByAuthor(String author);

    List<BooksDto> findByName(String name);

    List<BooksDto> findByIsbn(String isbn);

    List<BooksDto> findByPrice(Integer price);

    Integer deleteBooksById(Integer id);

    List<BooksDto> getBook();

//    List<BookWithCurrencies> getBooksWithCurrencies(String title);
//
//    List<BookWithCurrencyRange> getBookWithCurrencyRange(String title, String currency, int period);
}
