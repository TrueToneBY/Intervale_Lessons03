package intervale.dz3.springbookdemo.controller;



import intervale.dz3.springbookdemo.model.Book;
import intervale.dz3.springbookdemo.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
public class  BookController  {

    private final BooksService booksService;

    @Autowired
    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }





    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBooks() {
        final List<Book> books = booksService.getAllBooks();

        return books != null && !books.isEmpty()
                ? new ResponseEntity<>(books,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/books/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> read(@PathVariable(name = "id")int id){
        final Book book = booksService.read(id);

        return book != null
                ? new ResponseEntity<>(book,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/books",method = RequestMethod.POST)
    public ResponseEntity<Object> createBook( @RequestBody Book book){
        booksService.createBook(book);
         return new ResponseEntity<>("new Book",HttpStatus.CREATED);
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateBooks(@PathVariable(name = "id") int id, @RequestBody Book book) {
        final boolean update = booksService.updateBooks(book , id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/books/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(name = "id")int id){
        final boolean delete = booksService.delete(id);
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }





    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException e){
        log.error(e.getMessage());
        return "Enter parametrs";
    }


}
