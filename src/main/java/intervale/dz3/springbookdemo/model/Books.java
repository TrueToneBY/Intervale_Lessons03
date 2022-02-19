package intervale.dz3.springbookdemo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Books  {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("name")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("pages")
    private int pages;

    @JsonProperty("weight")
    private double weight;

    @JsonProperty("price")
    private int price;

}
