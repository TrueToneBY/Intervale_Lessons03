package com.intervale.cources.library.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Books  {

    private Integer id;

    private String isbn;

    private String name;

    private String author;

    private int pages;

    private double weight;

    private int price;

}
