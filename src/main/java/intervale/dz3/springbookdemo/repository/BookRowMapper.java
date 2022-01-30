package intervale.dz3.springbookdemo.repository;

import intervale.dz3.springbookdemo.model.Books;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Books books = new Books();

        books.setId(rs.getInt("id"));
        books.setIsbn(rs.getString("isbn"));
        books.setName(rs.getString("name"));
        books.setAuthor(rs.getString("author"));
        books.setPages(rs.getInt("pages"));
        books.setWeight(rs.getDouble("weight"));
        books.setPrice(rs.getBigDecimal("price"));

        return books;

    }
}
