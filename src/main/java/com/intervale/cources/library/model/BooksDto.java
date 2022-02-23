package com.intervale.cources.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksDto {
    private Integer id;

    private String isbn;

    private String name;

    private String author;

    private int pages;

    private double weight;

    private int price;


}
