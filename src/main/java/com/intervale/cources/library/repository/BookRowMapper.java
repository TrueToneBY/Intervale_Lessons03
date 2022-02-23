package com.intervale.cources.library.repository;

import com.intervale.cources.library.model.BooksDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<BooksDto> {


    @Override
    public BooksDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        BooksDto books = new BooksDto();

        books.setId(rs.getInt("id"));
        books.setIsbn(rs.getString("isbn"));
        books.setName(rs.getString("name"));
        books.setAuthor(rs.getString("author"));
        books.setPages(rs.getInt("pages"));
        books.setWeight(rs.getDouble("weight"));
        books.setPrice(rs.getInt("price"));

        return books;

    }

}
