package com.intervale.cources.library.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksDto {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 0, max = 20)
    private String isbn;

    @NotBlank
    @Size(min = 0, max = 20)
    private String name;

    @NotBlank
    @Size(min = 0, max = 20)
    private String author;

    @NotBlank
    @Size(min = 0, max = 20)
    private int pages;

    @NotBlank
    @Size(min = 0, max = 20)
    private double weight;

    @NotBlank
    @Size(min = 0, max = 20)
    private int price;


}
