package intervale.dz3.springbookdemo.repository;

import intervale.dz3.springbookdemo.model.Books;
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
public class BookRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Books> getBook() {
        return jdbcTemplate.query("select id,isbn,name,author,pages,weight,price from books", new BookRowMapper());
    }

    public Books findById(Integer id) {
        String sql = "SELECT * FROM books WHERE ID = ?";
        try {
            return (Books) this.jdbcTemplate.queryForObject(
                    sql, new Object[]{id}, new BookRowMapper());
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    public boolean saveBooks(Books books) {
        String query = "insert into books values(?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ps.setInt(1, books.getId());
                ps.setString(2, books.getIsbn());
                ps.setString(3, books.getName());
                ps.setString(4, books.getAuthor());
                ps.setInt(5, books.getPages());
                ps.setDouble(6, books.getWeight());
                ps.setBigDecimal(7, books.getPrice());

                return ps.execute();
            }
        });

    }

    public Integer updateBooks(Books books) {
        String query = "update books set isbn=?, name=?, author=?, pages=?, weight=?, price=? WHERE id=?";
        Object[] params = {
                books.getIsbn(),
                books.getName(),
                books.getAuthor(),
                books.getPages(),
                books.getWeight(),
                books.getPrice(),
                books.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE, Types.BIGINT, Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteBooksById(Integer id) {
        return jdbcTemplate.update("delete from books where id = ?",id);
    }
}
