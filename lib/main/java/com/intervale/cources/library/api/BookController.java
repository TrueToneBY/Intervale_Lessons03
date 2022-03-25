package com.intervale.cources.library.api;

import com.intervale.cources.library.business.BooksRepository;
import com.intervale.cources.library.exception.BookNotFoundException;
import com.intervale.cources.library.model.Books;
import com.intervale.cources.library.model.BooksDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import java.awt.print.Book;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/books",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class  BookController  {

    @Autowired
    BooksRepository booksRepository;

    public BookController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping(value = "/name/{author}")
    public ResponseEntity<?> getBooksByAuthor(@PathVariable("author")String author){
        List<BooksDto> books = booksRepository.findByAuthor(author);
        if (books.toArray().length == 0 ){
            return new ResponseEntity<String>("Нет такого автора = " + author, HttpStatus.NOT_FOUND);
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


//    @Operation(summary = "Get all foos")
//    @ApiResponses(value = [
//            ApiResponse(responseCode = "200", description = "Found Foos", content = [
//            (Content(mediaType = "application/json", array = (
//                    ArraySchema(schema = Schema(implementation = Foo::class)))))]),
//    ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
//    ApiResponse(responseCode = "404", description = "Did not find any Foos", content = [Content()])]
//            )
    @GetMapping
    public List<BooksDto> getAllBooks() {
        log.info("Сработал GET запрос getAllBooks");
        return booksRepository.getBook();

    }


    //для swagger
    @Operation(summary = "Get a book by its id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Found the book",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = Book.class)) }),
//            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
//                    content = @Content),
//            @ApiResponse(responseCode = "404", description = "Book not found",
//                    content = @Content) })
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
    public ResponseEntity<String> createBooks(@RequestBody BooksDto books) {
        if (booksRepository.findBooksById(books.getId()) != null){
            //log.error("Введите параметры " + books.getId(),HttpStatus.IM_USED);
            return new ResponseEntity<String>("Введите параметры " + books.getId(),HttpStatus.IM_USED);
        }
        log.info("Сработал Post запрос /create");
        booksRepository.saveBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBooks(@RequestBody BooksDto books){
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
        return new ResponseEntity<BooksDto>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException e){
        log.error(e.getMessage());
        return "Enter parametrs";
    }

}
