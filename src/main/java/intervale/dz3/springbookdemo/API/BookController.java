package intervale.dz3.springbookdemo.API;

import intervale.dz3.springbookdemo.BL.BooksRepository;
import intervale.dz3.springbookdemo.booksJson.model.Open;
import intervale.dz3.springbookdemo.booksJson.model.Post;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;


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

//    @RequestMapping(value ="/name/{name}", method = RequestMethod.GET)
//    @ResponseBody
//    public void searchByStudent(@PathVariable("name") String name) {
//        SqlRowSet resultSet = this.jdbcTemplate.queryForRowSet("SELECT name FROM books where name = ? ", new Object[]{name});
//        System.out.println(resultSet);
//
//    }
    @GetMapping(value = "/id/name/{name}")
    public ResponseEntity<?> getBooksIdName(@PathVariable("name")String name){
       Books books = booksRepository.ByIdBooksName(name);
        if (books == null ){
            return new ResponseEntity<String>("Нет книги по такому id " + name, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Books>((Books) books,HttpStatus.OK);
    }

    @RequestMapping(value = "/getBooks")
    public Books[] getProductList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        log.info("Good Parsing");
        return restTemplate.exchange("http://localhost:8081/books", HttpMethod.GET, entity, Books[].class).getBody();
    }
    @RequestMapping(value = "/getOpen")
    public Open[] getOpentList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        log.info("Good Parsing");
        return restTemplate.exchange("http://openlibrary.org/api/get?key=/b/OL1001932M", HttpMethod.GET, entity, Open[].class).getBody();
    }



    @GetMapping
    public List<BooksDto> getAllBooks(){
        return booksRepository.getBook();
    }


    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getBooksId(@PathVariable("id")Integer id){
        BooksDto books = booksRepository.findBooksById(id);
        if (books == null){
            return new ResponseEntity<String>("Нет книги по такому id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BooksDto>(books,HttpStatus.OK);
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
