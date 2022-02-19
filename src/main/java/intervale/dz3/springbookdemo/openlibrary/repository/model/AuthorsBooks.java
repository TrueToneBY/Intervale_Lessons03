package intervale.dz3.springbookdemo.openlibrary.repository.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import intervale.dz3.springbookdemo.openlibrary.repository.model.deserializer.AuthorsBooksDeserializer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonDeserialize(using = AuthorsBooksDeserializer.class)
public class AuthorsBooks {
    private List<String> books_olid;

    public AuthorsBooks() {
        books_olid = new ArrayList<>();
    }

    public void addBook(String book_olid) {
        books_olid.add(book_olid);
    }
}
