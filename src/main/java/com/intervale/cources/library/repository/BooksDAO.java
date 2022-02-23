package com.intervale.cources.library.repository;

import com.intervale.cources.library.business.BooksRepository;
import com.intervale.cources.library.model.Books;
import com.intervale.cources.library.model.BooksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class BooksDAO extends BookRowMapper implements BooksRepository<BooksDto> {

    final String GET_QUERY = "select id,isbn,name,author,pages,weight,price from books";
    final String GET_BY_ID_QUERY = "SELECT * FROM books WHERE ID = ?";
    final String GET_BY_AUTHOR_QUERY = "SELECT * FROM Books where author = ?";
    final String GET_BY_NAME_QUERY = "SELECT * FROM Books where name = ?";
    final String GET_BY_ISBN_QUERY = "SELECT * FROM Books where isbn = ?";
    final String INSERT_QUERY = "insert into books values(?,?,?,?,?,?,?)";
    final String UPDATE_QUERY = "update books set isbn=?, name=?, author=?, pages=?, weight=?, price=? WHERE id=?";
    final String DELETE_QUERY = "delete from books where id = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<BooksDto> getBooksByAuthor(String author) {
        String sql = "SELECT * FROM BOOKS WHERE author LIKE LOWER(?)";
        return jdbcTemplate.query(sql, new BookRowMapper(), new String[] {'%' + author + '%'});
    }


    @Override
    public List<BooksDto> getBook() {
        return jdbcTemplate.query(GET_QUERY, new BookRowMapper());
    }


    @Override
    public BooksDto findBooksById(Integer id) {
        try {
            return (BooksDto) this.jdbcTemplate.queryForObject(
                    GET_BY_ID_QUERY, new Object[]{id}, new BookRowMapper());
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public List<BooksDto> findByAuthor(String author) {
        try {
            return jdbcTemplate.query(GET_BY_AUTHOR_QUERY,new BookRowMapper(),author);
        }catch (Exception exception){
            return null;
        }
    }

    @Override
    public List<BooksDto> findByName(String name) {
        try {
            return jdbcTemplate.query(GET_BY_NAME_QUERY,new BookRowMapper(),name);
        }catch (Exception exception){
            return null;
        }
    }
    @Override
    public List<BooksDto> findByIsbn(String isbn) {
        try {
            return jdbcTemplate.query(GET_BY_ISBN_QUERY,new BookRowMapper(),isbn);
        }catch (Exception exception){
            return null;
        }
    }


    @Override
    public boolean saveBooks(Books books) {
        return jdbcTemplate.execute(INSERT_QUERY, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ps.setInt(1, books.getId());
                ps.setString(2, books.getIsbn());
                ps.setString(3, books.getName());
                ps.setString(4, books.getAuthor());
                ps.setInt(5, books.getPages());
                ps.setDouble(6, books.getWeight());
                ps.setInt(7, books.getPrice());

                return ps.execute();
            }
        });

    }

    @Override
    public Integer updateBooks(Books books) {
        Object[] params = {
                books.getIsbn(),
                books.getName(),
                books.getAuthor(),
                books.getPages(),
                books.getWeight(),
                books.getPrice(),
                books.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE, Types.BIGINT, Types.INTEGER};

        return jdbcTemplate.update(UPDATE_QUERY, params, types);
    }

    @Override
    public Integer deleteBooksById(Integer id) {
        return jdbcTemplate.update(DELETE_QUERY, id);
    }

}
