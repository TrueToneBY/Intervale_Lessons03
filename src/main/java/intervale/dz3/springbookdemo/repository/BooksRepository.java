package intervale.dz3.springbookdemo.repository;

import intervale.dz3.springbookdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book,Integer> {
}
