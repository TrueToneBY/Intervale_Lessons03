package intervale.dz3.springbookdemo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import intervale.dz3.springbookdemo.deserialazer.BooksDeserialazer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@JsonDeserialize(using = BooksDeserialazer.class)
@Validated
public class Books  {

    private Integer id;

    private String isbn;

    private String name;

    private String author;

    private int pages;

    private double weight;

    private int price;
    private boolean book;

    public Books() {

    }

}
