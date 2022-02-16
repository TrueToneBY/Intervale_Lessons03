package intervale.dz3.springbookdemo.BL;

import intervale.dz3.springbookdemo.model.Books;

import java.util.List;

public interface BooksRepository {

    boolean saveBooks  (Books books);

    Integer updateBooks(Books books);

    Books findBooksById(Integer id);

    Books ByIdBooksName(String name);

    Integer deleteBooksById(Integer id);

    List<Books> getBook();
}
