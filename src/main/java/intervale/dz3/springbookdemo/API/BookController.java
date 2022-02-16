package intervale.dz3.springbookdemo.API;



import intervale.dz3.springbookdemo.BL.BooksRepository;
import intervale.dz3.springbookdemo.model.Books;
import intervale.dz3.springbookdemo.repository.BooksDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/books",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class  BookController  {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BooksRepository booksRepository;

//    @Autowired
//    BooksDAO booksDAO;

//    @RequestMapping(value ="/name/{name}", method = RequestMethod.GET)
//    @ResponseBody
//    public void searchByStudent(@PathVariable("name") String name) {
//        SqlRowSet resultSet = this.jdbcTemplate.queryForRowSet("SELECT name FROM books where name = ? ", new Object[]{name});
//        System.out.println(resultSet);
//
//    }
    @GetMapping(value = "/id/name/{name}")
    public ResponseEntity<?> getBooksIdName(@PathVariable("name")String id){
        Books books = booksRepository.ByIdBooksName(id);
        if (books == null ){
            return new ResponseEntity<String>("Нет книги по такому id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Books>(books,HttpStatus.OK);
    }



    @GetMapping
    public List<Books> getAllBooks(){
        return booksRepository.getBook();
    }


    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getBooksId(@PathVariable("id")Integer id){
        Books books = booksRepository.findBooksById(id);
        if (books == null){
            return new ResponseEntity<String>("Нет книги по такому id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Books>(books,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> createBooks(@RequestBody Books books) throws SQLIntegrityConstraintViolationException {
        if (booksRepository.findBooksById(books.getId()) != null){
            return new ResponseEntity<String>("Введите параметры " + books.getId(),HttpStatus.IM_USED);
        }
        booksRepository.saveBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> updateBooks(@RequestBody Books books){
        if (booksRepository.findBooksById(books.getId()) == null){
            return new ResponseEntity<String>("Обновить список Книги не  удалось по id " + books.getId() + " не найдено",HttpStatus.NOT_FOUND);
        }
        booksRepository.updateBooks(books);
        return new ResponseEntity<Books>(books,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable("id") Integer id){
        Books books = booksRepository.findBooksById(id);
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
