package com.intervale.cources.library.repository;

import com.intervale.cources.library.business.BooksRepository;
import com.intervale.cources.library.external.alfabank.model.BookWithCurrencies;
import com.intervale.cources.library.external.alfabank.model.BookWithCurrencyRange;
import com.intervale.cources.library.external.alfabank.model.Rate;
import com.intervale.cources.library.external.alfabank.model.RateListResponse;
//import com.intervale.cources.library.external.alfabank.service.impl.AlfaBankServiceImpl;
import com.intervale.cources.library.external.alfabank.service.impl.AlfaBankServiceImpl;
import com.intervale.cources.library.model.Books;
import com.intervale.cources.library.model.BooksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import java.awt.print.Book;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BooksDAO extends BookRowMapper implements BooksRepository<BooksDto> {

    final String GET_QUERY = "select id,isbn,name,author,pages,weight,price from books";
    final String GET_BY_ID_QUERY = "SELECT * FROM books WHERE ID = ?";
    final String GET_BY_AUTHOR_QUERY = "SELECT * FROM Books where author = ?";
    final String GET_BY_NAME_QUERY = "SELECT * FROM Books where name = ?";
    final String GET_BY_ISBN_QUERY = "SELECT * FROM Books where isbn = ?";
    final String GET_BY_PRICE = "select * from Books where price = ?";
    final String INSERT_QUERY = "insert into books values(?,?,?,?,?,?,?)";
    final String UPDATE_QUERY = "update books set isbn=?, name=?, author=?, pages=?, weight=?, price=? WHERE id=?";
    final String DELETE_QUERY = "delete from books where id = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;
//    @Autowired
//    AlfaBankServiceImpl alfaBankService;
//    @Autowired
//    BooksDAO booksDAO;


    public List<BooksDto> getBooksByAuthor(String author) {
        String sql = "SELECT * FROM BOOKS WHERE author LIKE LOWER(?)";
        return jdbcTemplate.query(sql, new BookRowMapper(), new String[]{'%' + author + '%'});
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
            return jdbcTemplate.query(GET_BY_AUTHOR_QUERY, new BookRowMapper(), author);
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public List<BooksDto> findByName(String name) {
        try {
            return jdbcTemplate.query(GET_BY_NAME_QUERY, new BookRowMapper(), name);
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public List<BooksDto> findByIsbn(String isbn) {
        try {
            return jdbcTemplate.query(GET_BY_ISBN_QUERY, new BookRowMapper(), isbn);
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public List<BooksDto> findByPrice(Integer price) {
        try {
            return jdbcTemplate.query(GET_BY_PRICE, new BookRowMapper(), price);
        } catch (Exception exception) {
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
    public Integer updateBooks(BooksDto books) {
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
//
//    public List<BookWithCurrencies> getBooksWithCurrencies(String title) {
//        //Метод получает из сервиса список курсов валют из API Альфа-банка
//        RateListResponse rates = alfaBankService.getRateList();
//        System.out.println(rates.getRates());
//        //BookDao возвращает список книг с указанным названием
//        List<BooksDto> books = booksDAO.findByName(title);
//        System.out.println(books);
//        List<BookWithCurrencies> booksWithCurrencies = new ArrayList<>();
//        //Объединяет данные по книге и её стоимости
//        for (BooksDto book : books) {
//            booksWithCurrencies.add(convertBookToBookWithCurrency(book, rates.getRates()));
//        }
//        return booksWithCurrencies;
//    }
//}


//
//    /**
//     * Возвращает список книг с заданным названием и диапазоном их стоимости по дням в выбранной валюте
//     * @param title название книги для поиска
//     * @param currency код валюты согласно ISO
//     * @param period диапазон, в котором выполнить поиск курсов валют
//     * @return список книг с заданным названием и диапазоном их стоимости по дням в выбранной валюте
//     */
//    @Override
//    public List<BookWithCurrencyRange> getBookWithCurrencyRange(String title, String currency, int period) {
//        //BookDao возвращает список книг с указанным названием
//        List<BooksDto> books = booksDAO.findByName(title);
//        List<BookWithCurrencyRange> bookRangeCurrencies = new ArrayList<>();
//        if (books.size() != 0) {
//            //Метод получает из сервиса список диапазонов курсов валют из API Альфа-банка
//            Map<String, BigDecimal> rates = alfaBankService.getRatesInRange(currency, period);
//            //Конвертация в представление книги по её названию с диапазоном курсов валют
//            for (BooksDto book: books) {
//                bookRangeCurrencies.add(convertBookToBookWithCurrencyRange(book, rates));
//            }
//        }
//        return bookRangeCurrencies;
//    }
//
//    /**
//     * Конвертирует книгу из БД в
//     * @param book книга для конвертации
//     * @param rates список валют с указанием курса конвертации
//     * @return книга c заданным названием и стоимость в различных валютах
//     */
//    private BookWithCurrencies convertBookToBookWithCurrency(BooksDto book, List<Rate> rates) {
//        String byn = "BYN";
//        Map<String, BigDecimal> currencies = new LinkedHashMap<>();
//        //Определяет стоимость книги в BYN
//        BigDecimal bookPriceInByn = new BigDecimal(book.getPrice()/100.0).setScale(2, BigDecimal.ROUND_HALF_UP);
//        currencies.put(byn, bookPriceInByn);
//        //Цикл для добавления к списку пересчета стомости в указанной валюте
//        for (Rate rate: rates) {
//            if (rate.getBuyIso().equals(byn)) {
//                currencies.put(rate.getSellIso(), bookPriceInByn.divide(rate.getBuyRate(), BigDecimal.ROUND_HALF_UP));
//            }
//        }
//        BookWithCurrencies bookWithCurrencies = new BookWithCurrencies(book.getName(), currencies);
//        return bookWithCurrencies;
//    }
//
//    /**
//     * Конвертирует книгу из БД в книгу c диапазоном стоимости в выбранной валюте по дням, используя список курсов валюты по датам
//     * @param book книга из БД
//     * @param rates список курсов валюты по датам
//     * @return книга c заданным названием и диапазоном стоимости в выбранной валюте по дням
//     */
//    private BookWithCurrencyRange convertBookToBookWithCurrencyRange(BooksDto book, Map<String, BigDecimal> rates) {
//        BigDecimal bookPriceInByn = new BigDecimal(book.getPrice()/100.0).setScale(2, BigDecimal.ROUND_HALF_UP);
//        Map<String, BigDecimal> prices = new LinkedHashMap<>();
//        for (String date: rates.keySet()) {
//            prices.put(date, bookPriceInByn.divide(rates.get(date), BigDecimal.ROUND_HALF_UP));
//        }
//        BookWithCurrencyRange bookWithCurrencyRange = new BookWithCurrencyRange(book.getName(), prices);
//        return bookWithCurrencyRange;
//    }
//
//}
