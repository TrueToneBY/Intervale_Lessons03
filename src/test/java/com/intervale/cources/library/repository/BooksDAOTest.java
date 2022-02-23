package com.intervale.cources.library.repository;

import com.intervale.cources.library.business.BooksRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.yml")
public class BooksDAOTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    BooksRepository booksRepository;

    @Test
    public void getBook() {
        System.out.println(booksRepository.getBook());
    }

    @Test
    public void findBooksById() {
        System.out.println(booksRepository.findBooksById(5));
    }

    @Test
    public void findByAuthor() {
        System.out.println(String.valueOf(booksRepository.findByAuthor("Doe")));
    }

    @Test
    public void findByName() {
        System.out.println(String.valueOf(booksRepository.findByName("Josh")));
    }

    @Test
    public void findByISBN() {
        System.out.println(booksRepository.findByIsbn("43434343545"));
    }

    @Test
    public void saveBooks() {
    }

    @Test
    public void updateBooks() {
    }

    @Test
    public void deleteBooksById() {
    }
}