package intervale.dz3.springbookdemo.BL;

import intervale.dz3.springbookdemo.model.Books;
import intervale.dz3.springbookdemo.model.BooksDto;

import java.util.List;

public interface BooksRepository<k> {

    boolean saveBooks  (Books books);

    Integer updateBooks(Books books);

    BooksDto findBooksById(Integer id);

    List<BooksDto> findByAuthor(String author);

    List<BooksDto> findByName(String name);

    List<BooksDto> findByISBN(String isbn);

    Integer deleteBooksById(Integer id);

    List<BooksDto> getBook();

}
