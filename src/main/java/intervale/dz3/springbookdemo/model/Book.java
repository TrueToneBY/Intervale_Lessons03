package intervale.dz3.springbookdemo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import intervale.dz3.springbookdemo.util.BookDeserializer;
import lombok.Data;

import javax.validation.constraints.*;

import java.math.BigDecimal;

@Data
@JsonPropertyOrder({"id","isbn","name","author","pages","weight","price"})
@JsonDeserialize(using = BookDeserializer.class)
public class Book  {
//    BookResp bookResp = new BookResp();
//
//    {
//        bookResp.setId("20");
//        bookResp.setName("Pavel");
//        bookResp.setAuthor("I");
//    }



    private String id;
    //@NotNull(message = "Type in isbn")
    private String isbn;
    //@NotBlank(message = "Type in name")
    private String name;
    //@NotBlank(message = "Type in author")
    private String author;
    //@NotNull(message = "Type in pages")
    private int pages;
   // @NotNull(message = "Type in weight")
    private double weight;
//    @NotEmpty(message = "Type in price")
   // @DecimalMin("0.00")
    private BigDecimal price;



//    public Book(String author, String id, String isbn,String name) {
//        this.id = id;
//        this.isbn = isbn;
//        this.name = name;
//        this.author = author;
//        this.pages = pages;
//        this.weight = weight;
//        this.price = price;
//        this.value = value;
//    }
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
