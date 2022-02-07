package intervale.dz3.springbookdemo.controller;



import intervale.dz3.springbookdemo.model.Books;
import intervale.dz3.springbookdemo.repository.BooksDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/books")
public class  BookController  {
    public BookController(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @Autowired
    BooksDAO booksDAO;


    @GetMapping
    public List<Books> getAllBooks(){
        return booksDAO.getBook();
    }

//    @GetMapping("/books/author")
//    public ResponseEntity<?> gteAuthor(@PathVariable(name = "author",value ="")String author){
//       Books books = booksDAO.getAuthor(author);
//       if (books == null){
//           return new ResponseEntity<>(String.valueOf(author), HttpStatus.NOT_FOUND);
//       }
//       return new ResponseEntity<Books>(books,HttpStatus.OK);
//    }
    @GetMapping("/books")
    public ResponseEntity<List<Books>> findByBookName() {
        try {
            List<Books> tutorials = booksDAO.findByTitleBook(true);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getBooksId(@PathVariable("id")Integer id){
        Books books = booksDAO.findById(id);
        if (books == null){
            return new ResponseEntity<String>("Нет книги по такому id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Books>(books,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBooks(@RequestBody Books books) throws SQLIntegrityConstraintViolationException {
        if (booksDAO.findById(books.getId()) != null){
            return new ResponseEntity<String>("Введите параметры " + books.getId(),HttpStatus.IM_USED);
        }
        booksDAO.saveBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> updateBooks(@RequestBody Books books){
        if (booksDAO.findById(books.getId()) == null){
            return new ResponseEntity<String>("Обновить список Книги не  удалось по id " + books.getId() + " не найдено",HttpStatus.NOT_FOUND);
        }
        booksDAO.updateBooks(books);
        return new ResponseEntity<Books>(books,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable("id") Integer id){
        Books books = booksDAO.findById(id);
        if (books == null){
            return new ResponseEntity<String>("Удалить книгу не удалось по id " + id + " не найдено" ,HttpStatus.NOT_FOUND);
        }
        booksDAO.deleteBooksById(id);
        return new ResponseEntity<Books>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException e){
        log.error(e.getMessage());
        return "Enter parametrs";
    }

}
