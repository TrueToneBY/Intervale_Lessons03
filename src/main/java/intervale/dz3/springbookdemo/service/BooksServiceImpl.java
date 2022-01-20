package intervale.dz3.springbookdemo.service;

import intervale.dz3.springbookdemo.model.Book;
import intervale.dz3.springbookdemo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BooksServiceImpl implements BooksService{
    private BooksRepository booksRepository;


    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void createBook(Book book) {
        booksRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Book read(int id) {
        return booksRepository.getOne(id);
    }

    @Override
    public boolean updateBooks(Book book, int id) {
        if (booksRepository.existsById(id)){
            book.setId(id);
            booksRepository.save(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (booksRepository.existsById(id)){
            booksRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
