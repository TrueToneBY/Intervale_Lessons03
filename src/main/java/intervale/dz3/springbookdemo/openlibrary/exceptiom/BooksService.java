package intervale.dz3.springbookdemo.openlibrary.exceptiom;

import intervale.dz3.springbookdemo.model.BookOpenLib;
import intervale.dz3.springbookdemo.model.Books;
import intervale.dz3.springbookdemo.repository.BookRowMapper;
import intervale.dz3.springbookdemo.repository.BooksDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksDAO booksDAO;

    public BooksService(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }
    @Autowired
    private BookRowMapper bookRowMapper;


}
