package intervale.dz3.springbookdemo.controller;



import intervale.dz3.springbookdemo.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
//@Valid
@RestController
public class  BookController {



    @NotNull
    private static Map<Long, @Valid Book> bookMap = new HashMap<>();

     {
        Book book = new Book();
        book.setId(1L);
        book.setIsbn("45654675432434");
        book.setName("History");
        book.setAuthor("Pavel");
        book.setWeight(2.2);
        book.setPages(100);
        book.setPrice(BigDecimal.valueOf(123.45));

        bookMap.put(book.getId(), book);

        Book book1 = new Book();
        book1.setId(2L);
        book1.setIsbn("343434343434");
        book1.setName("History");
        book1.setAuthor("Dog");
        book1.setWeight(2);
        book1.setPages(80);
        book1.setPrice(BigDecimal.valueOf(99.99));

        bookMap.put(book1.getId(), book1);

    }


    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBooks() {
        return new ResponseEntity<>(bookMap.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/books",method = RequestMethod.POST)
    public ResponseEntity<Object> createBook(@Valid @RequestBody Book book ){
         bookMap.put(book.getId(),book);
         return new ResponseEntity<>("new Book",HttpStatus.CREATED);
//         if(book.getName() != null && !book.getName().isEmpty() ){
//             bookMap.put(book.getId(),book);
//
//             return new ResponseEntity<>("Book was added",   HttpStatus.CREATED);
//         }
//      else {
//             return new ResponseEntity<>("Book was not added",   HttpStatus.BAD_REQUEST);
//         }
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateBooks(@PathVariable("id") Long id, @RequestBody Book book) {
        bookMap.remove(id);
        book.setId(id);
        bookMap.put(id, book);
        return new ResponseEntity<>("Book was updated successfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/books/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        bookMap.remove(id);
        return new ResponseEntity<>("Books were deleted",HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException e){
        log.error(e.getMessage());
        return "Enter parametrs";
    }

//    @RequestMapping(value = "/books1", method = RequestMethod.POST)
//    public ResponseEntity<Object> createBook1(@RequestBody Book book) {
//        bookMap.put(book.getId(), book);
//        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
//    }
}
