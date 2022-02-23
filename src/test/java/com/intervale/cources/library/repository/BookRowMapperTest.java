package com.intervale.cources.library.repository;

import com.intervale.cources.library.business.BooksRepository;
import com.intervale.cources.library.model.BooksDto;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.mock;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={ BooksDAO.class })
public class BookRowMapperTest {

    @Autowired
    BooksDAO booksDAO;

    public void getTest(){
        Mockito.when(booksDAO.getBook());
    }



    @Test
    public void mapRow() throws SQLException {
        BooksRepository repository = new BooksDAO();
        List<BooksDAO> booksDAOList = repository.getBook();

        System.out.println(booksDAOList);



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
    @Test
    public void testFindByAuthor(){
        BooksRepository repository = new BooksDAO();
        List<BooksDAO> booksDAOList = repository.findByAuthor("Vassily");
        System.out.println(booksDAOList);

    }
    @Test
    public void testgetBooksByAuthor(){
        BooksDAO booksDAO = new BooksDAO();
        List<BooksDto> booksDAOList = booksDAO.getBooksByAuthor("author");
        System.out.println(booksDAOList);
    }

}