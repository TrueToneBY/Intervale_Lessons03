package intervale.dz3.springbookdemo.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class BooksDto {
    private Integer id;

    private String isbn;

    private String name;

    private String author;

    private int pages;

    private double weight;

    private int price;
}
