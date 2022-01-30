package intervale.dz3.springbookdemo.controller;



import intervale.dz3.springbookdemo.model.Books;
import intervale.dz3.springbookdemo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class  BookController  {
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    BookRepository bookRepository;


    @GetMapping
    public List<Books> getAllBooks(){
        return bookRepository.getBook();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getBooks(@PathVariable("id")Integer id){
        Books books = bookRepository.findById(id);
        if (books == null){
            return new ResponseEntity<String>("Нет книги по такому id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Books>(books,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBooks(@RequestBody Books books) throws SQLIntegrityConstraintViolationException {
        if (bookRepository.findById(books.getId()) != null){
            return new ResponseEntity<String>("Введите параметры " + books.getId(),HttpStatus.IM_USED);
        }
        bookRepository.saveBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> updateBooks(@RequestBody Books books){
        if (bookRepository.findById(books.getId()) == null){
            return new ResponseEntity<String>("Обновить список Книги не  удалось по id " + books.getId() + " не найдено",HttpStatus.NOT_FOUND);
        }
        bookRepository.updateBooks(books);
        return new ResponseEntity<Books>(books,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable("id") Integer id){
        Books books = bookRepository.findById(id);
        if (books == null){
            return new ResponseEntity<String>("Удалить книгу не удалось по id " + id + " не найдено" ,HttpStatus.NOT_FOUND);
        }
        bookRepository.deleteBooksById(id);
        return new ResponseEntity<Books>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException e){
        log.error(e.getMessage());
        return "Enter parametrs";
    }

}
