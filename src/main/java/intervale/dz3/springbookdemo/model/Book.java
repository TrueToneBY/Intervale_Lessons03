package intervale.dz3.springbookdemo.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.*;

import java.math.BigDecimal;

@Data
public class Book {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull(message = "Type in isbn")
    @Size(min = 0,max = 20,message = "20ти значный isbn ")
    private long Isbn;
    @NotBlank(message = "Type in name")
    private String name;
    @NotBlank(message = "Type in author")
    private String author;
    @NotBlank(message = "Type in pages")
    private int pages;
    @NotBlank(message = "Type in weight")
    private double weight;
    @NotEmpty(message = "Type in price")
    @DecimalMin("0.00")
    private BigDecimal price;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Long getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(Long isbn) {
//        this.isbn = isbn;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public int getPages() {
//        return pages;
//    }
//
//    public void setPages(int pages) {
//        this.pages = pages;
//    }
//
//    public double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public Book(int id, Long isbn, String name, String author, int pages, double weight, BigDecimal price) {
//        this.id = id;
//        this.isbn = isbn;
//        this.name = name;
//        this.author = author;
//        this.pages = pages;
//        this.weight = weight;
//        this.price = price;
//    }

}
