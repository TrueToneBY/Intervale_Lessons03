package com.intervale.cources.library.api;

import com.intervale.cources.library.business.BooksRepository;
import com.intervale.cources.library.model.Books;
import com.intervale.cources.library.model.BooksDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/books",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class  BookController  {

    @Autowired
    BooksRepository booksRepository;


    @GetMapping(value = "/name/{author}")
    public ResponseEntity<?> getBooksByAuthor(@PathVariable("author")String author){
        List<BooksDto> books = booksRepository.findByAuthor(author);
        if (books.toArray().length == 0 ){
            return new ResponseEntity<String>("Нет такого автора" + author, HttpStatus.NOT_FOUND);
        }
        log.info("Сработал GET запрос /name/{author}");
        return new ResponseEntity<List>(books,HttpStatus.OK);
    }

    @GetMapping(value = "/price/{title}")
    public ResponseEntity<?> getBooksByPrice(@PathVariable("title")Integer price){
        List<BooksDto> books = booksRepository.findByPrice(price);
        if (books.toArray().length <= 0){
            return new ResponseEntity<String>("Нет такой книги по price " + price,HttpStatus.NOT_FOUND);
        }
        log.info("Сработал GET запрос /price/{title}");
        return new ResponseEntity<List>(books,HttpStatus.OK);
    }


    @GetMapping(value = "/title/{name}")
    public ResponseEntity<?> getBooksByName(@PathVariable("name")String name){
        List<BooksDto> books = booksRepository.findByName(name);
        if ( books.toArray().length == 0){
            return new ResponseEntity<String>("Нет такой книги  " + name, HttpStatus.NOT_FOUND);
        }
        log.info("Сработал GET запрос /title/{name}");
        return new ResponseEntity<List>(books,HttpStatus.OK);
    }


    @GetMapping(value = "/isbn/{isbn}")
    public ResponseEntity<?> getBooksByISBN(@PathVariable("isbn")String isbn){
        List<BooksDto> books = booksRepository.findByIsbn(isbn);
        if (books.toArray().length == 0){
            return new ResponseEntity<String>("Нет такой книги isbn " + isbn, HttpStatus.NOT_FOUND);
        }
        log.info("Сработал GET запрос /isbn/{isbn}");
        return new ResponseEntity<List>(books,HttpStatus.OK);
    }


    @GetMapping
    public List<BooksDto> getAllBooks(){
        log.info("Сработал GET запрос getAllBooks");
        return booksRepository.getBook();

    }


    @GetMapping(value = "/get/id/{id}")
    public ResponseEntity<?> getBooksId(@PathVariable("id")Integer id){
        BooksDto books = booksRepository.findBooksById(id);
        if (books == null ){
            return new ResponseEntity<String>("Нет книги по такому id " + id, HttpStatus.NOT_FOUND);
        }
        log.info("Сработал GET запрос /get/id/{id}");
        return new ResponseEntity<BooksDto>(books,HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<String> createBooks(@RequestBody Books books) throws SQLIntegrityConstraintViolationException {
        if (booksRepository.findBooksById(books.getId()) != null){
            return new ResponseEntity<String>("Введите параметры " + books.getId(),HttpStatus.IM_USED);
        }
        log.info("Сработал Post запрос /create");
        booksRepository.saveBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBooks(@RequestBody Books books){
        if (booksRepository.findBooksById(books.getId()) == null){
            return new ResponseEntity<String>("Обновить список Книги не  удалось по id " + books.getId() + " не найдено",HttpStatus.NOT_FOUND);
        }
        log.info("Сработал Put запрос /update");
        booksRepository.updateBooks(books);
        return new ResponseEntity<Books>(books,HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable("id") Integer id){
        BooksDto books = booksRepository.findBooksById(id);
        if (books == null){
            return new ResponseEntity<String>("Удалить книгу не удалось по id " + id + " не найдено" ,HttpStatus.NOT_FOUND);
        }
        log.info("Сработал Delete запрос /delete/{id}");
        booksRepository.deleteBooksById(id);
        return new ResponseEntity<Books>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException e){
        log.error(e.getMessage());
        return "Enter parametrs";
    }

}
