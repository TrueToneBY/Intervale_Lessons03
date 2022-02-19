package intervale.dz3.springbookdemo.openlibrary.repository;

import intervale.dz3.springbookdemo.model.Books;
import intervale.dz3.springbookdemo.model.BooksDto;
import intervale.dz3.springbookdemo.openlibrary.repository.model.AuthorsBooks;
import intervale.dz3.springbookdemo.openlibrary.repository.model.AuthorsWorks;
import intervale.dz3.springbookdemo.openlibrary.repository.model.OpenLibraryBook;
import intervale.dz3.springbookdemo.repository.BooksDAO;

import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenLibraryService {
    @Autowired
    RestTemplate template;

    @Autowired
    BooksDAO bookDao;

    private final static String AUTHOR_SEARCH = "/search.json?author=";
    private final static String BOOK_SEARCH = "/api/books?bibkeys=OLID:";
    private final static String SEARCH_RESPONSE_FORMAT = "&jscmd=data&format=json";

    public List<org.hibernate.jdbc.Work> getWorksByAuthor(String author) {
        List<Work> works = template.getForObject(AUTHOR_SEARCH + author, AuthorsWorks.class).getDocs();
        works.addAll(bookDao.getBooksByAuthorAsWork(author));
        return works;
    }

    public Map<String, Object> getBooksByAuthor(String author) {
        HashMap<String, Object> books = new HashMap<>();
        List<OpenLibraryBook> booksFromOl = getBooksByAuthorFromOpenLibrary(author);
        List<BooksDto> booksFromDb = getBooksByAuthorFromDb(author);
        String noBooksFound = "No books found for author \'" + author + "\'.";
        books.put("Books from Opel Library", booksFromOl.size() != 0 ? booksFromOl : noBooksFound);
        books.put("Books from database", booksFromDb.size() != 0 ? booksFromDb : noBooksFound);
        return books;
    }

    private List<BooksDto> getBooksByAuthorFromDb(String author) {
        return bookDao.getBooksByAuthor(author);
    }

    private List<OpenLibraryBook> getBooksByAuthorFromOpenLibrary(String author) {
        AuthorsBooks authorsBooks = template.getForObject(AUTHOR_SEARCH + author, AuthorsBooks.class);
        List<OpenLibraryBook> books = new ArrayList<>();
        for (String olid: authorsBooks.getBooks_olid()) {
            OpenLibraryBook book = template.getForObject( BOOK_SEARCH+ olid +SEARCH_RESPONSE_FORMAT, OpenLibraryBook.class);
            book.setOlid(olid);
            books.add(book);
        }
        return books;
    }
}