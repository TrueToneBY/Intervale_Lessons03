package intervale.dz3.springbookdemo.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Books {

    private Integer id;

    private String isbn;

    private String name;

    private String author;

    private int pages;

    private double weight;

    private BigDecimal price;

}
