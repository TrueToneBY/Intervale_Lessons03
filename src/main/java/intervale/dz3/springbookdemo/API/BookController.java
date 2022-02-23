package intervale.dz3.springbookdemo.API;

import intervale.dz3.springbookdemo.BL.BooksRepository;
import intervale.dz3.springbookdemo.model.Books;
import intervale.dz3.springbookdemo.model.BooksDto;
import intervale.dz3.springbookdemo.repository.BooksDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/books",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class  BookController  {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    BooksDAO booksDAO;

    @GetMapping(value = "/name/{author}")
    public ResponseEntity<?> getBooksbyAuthor(@PathVariable("author")String author){
        List<BooksDto> books = booksRepository.findByAuthor(author);
        if (books.toArray().length == 0 ){
            return new ResponseEntity<String>("Нет такого автора" + author, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List>(books,HttpStatus.OK);
    }


    @GetMapping(value = "/title/{name}")
    public ResponseEntity<?> getBooksbyName(@PathVariable("name")String name){
        List<BooksDto> books = booksRepository.findByName(name);
        if ( books.toArray().length == 0){
            return new ResponseEntity<String>("Нет такоq книги  " + name, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List>(books,HttpStatus.OK);
    }


    @GetMapping(value = "/isbn/{isbn}")
    public ResponseEntity<?> getBooksbyISBN(@PathVariable("isbn")String isbn){
        List<BooksDto> books = booksRepository.findByISBN(isbn);
        if (books.toArray().length == 0){
            return new ResponseEntity<String>("Нет такоq книги isbn " + isbn, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List>(books,HttpStatus.OK);
    }


    @GetMapping
    public List<BooksDto> getAllBooks(){
        return booksRepository.getBook();
    }


    @GetMapping(value = "/get/id/{id}")
    public ResponseEntity<?> getBooksId(@PathVariable("id")Integer id){
        BooksDto books = booksRepository.findBooksById(id);
        if (books == null ){
            return new ResponseEntity<String>("Нет книги по такому id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BooksDto>(books,HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<String> createBooks(@RequestBody Books books) throws SQLIntegrityConstraintViolationException {
        if (booksRepository.findBooksById(books.getId()) != null){
            return new ResponseEntity<String>("Введите параметры " + books.getId(),HttpStatus.IM_USED);
        }
        booksRepository.saveBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBooks(@RequestBody Books books){
        if (booksRepository.findBooksById(books.getId()) == null){
            return new ResponseEntity<String>("Обновить список Книги не  удалось по id " + books.getId() + " не найдено",HttpStatus.NOT_FOUND);
        }
        booksRepository.updateBooks(books);
        return new ResponseEntity<Books>(books,HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable("id") Integer id){
        BooksDto books = booksRepository.findBooksById(id);
        if (books == null){
            return new ResponseEntity<String>("Удалить книгу не удалось по id " + id + " не найдено" ,HttpStatus.NOT_FOUND);
        }
        booksRepository.deleteBooksById(id);
        return new ResponseEntity<Books>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException e){
        log.error(e.getMessage());
        return "Enter parametrs";
    }

}
