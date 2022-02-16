package intervale.dz3.springbookdemo.repository;

import intervale.dz3.springbookdemo.model.Books;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookRowMapperTest {

    @Test
    public void mapRow() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
//
//        when(rs.getInt("id")).thenReturn(1);
//        when(rs.getString("isbn")).thenReturn("2232323232323");
//        when(rs.getString("name")).thenReturn("Pavel");
//       when(rs.getString("author")).thenReturn("Lit");
//        when(rs.getInt("pages")).thenReturn(2);
//        when(rs.getDouble("weight")).thenReturn(40.0);
//        when(rs.getInt("price")).thenReturn(100);
//
//        Books books = new Books(1,"2232323232323","Pavel","Lit",2,40.0,100);
//        Assert.assertEquals(books,new BookRowMapper().mapRow(rs,1));
//
    }
}