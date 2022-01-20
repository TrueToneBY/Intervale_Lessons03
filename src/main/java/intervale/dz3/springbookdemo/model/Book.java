package intervale.dz3.springbookdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

//@JsonDeserialize(using = BookDeserializer.class)
public class Book  {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "booksIdSeq", sequenceName = "books_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booksIdSeq")
    private Integer id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "pages")
    private int pages;

    @Column(name = "weight")
    private int weight;

    @Column(name = "price")
    private int price;

}
