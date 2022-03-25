//package com.intervale.cources.library.external.alfabank.api;
//
//
//import com.intervale.cources.library.external.alfabank.model.BookWithCurrencies;
//import com.intervale.cources.library.external.alfabank.model.BookWithCurrencyRange;
//import com.intervale.cources.library.repository.BooksDAO;
//import io.swagger.annotations.ApiResponse;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.constraints.NotBlank;
//import java.util.List;
//
//@Validated
//@RestController
//@Tag(name = "Alfa-Bank Controller", description = "Контроллер для работы с книгами в интеграции с API Альфа-банка.")
//public class AlfaBankController {
//    @Autowired
//    BooksDAO booksDAO;
//
//    /**
//     * Получить стоимость книги в различных валютах по её названию
//     * @param title Название книги в БД.
//     * @return Список книг с заданным названием из БД и стоимостью в различных валютах по курсу Альфа-банка
//     */
//    @GetMapping("/price/{title}")
//    @Operation(summary = "Получить стоимость книги в различных валютах по её названию.")
//    public ResponseEntity getPriceByTitle(@PathVariable @Parameter(description = "Название книги в БД.") @NotBlank String title) {
//        List<BookWithCurrencies> bookCurrencies = booksDAO.getBooksWithCurrencies(title);
//        ResponseEntity response;
//        if (bookCurrencies.size() != 0) {
//            response = new ResponseEntity(bookCurrencies, HttpStatus.OK);
//        }
//        else {
//            response = new ResponseEntity("No books with title '" + title + "' found.", HttpStatus.OK);
//        }
//        return response;
//    }
//
//    /**
//     * Получить стоимость книги в заданном диапазоне по дням в выбранной валюте по курсу НБ РБ (выходные дни не отображаются)
//     * @param title название книги для поиска
//     * @param currency код валюты согласно ISO
//     * @return список книг с заданным названием и диапазоном их стоимости по дням в выбранной валюте
//     */
//    @GetMapping("/price/{title}/{currency}")
//    @Operation(summary = "Получить стоимость книги в заданном диапазоне по дням в выбранной валюте по курсу " +
//            "НБ РБ (выходные дни не отображаются).")
//    public ResponseEntity<?> getPriceByTitleInDynamics(
//            @PathVariable @Parameter(description = "Название книги в БД.") @NotBlank String title,
//            @PathVariable @Parameter(description = "Код валюты согласно ISO.") @NotBlank String currency) {
//        final int period = 30;
//        List<BookWithCurrencyRange> bookRangeCurrencies = booksDAO.getBookWithCurrencyRange(title, currency, period);
//        ResponseEntity<?> response;
//        if (bookRangeCurrencies.size() != 0) {
//            if (bookRangeCurrencies.get(0).getPrices().size() != 0) {
//                response = new ResponseEntity<>(bookRangeCurrencies, HttpStatus.OK);
//            }
//            else {
//                response = new ResponseEntity<>("No currency '" + currency + "' found.", HttpStatus.OK);
//            }
//        }
//        else {
//            response = new ResponseEntity<>("No books with title '" + title + "' found.", HttpStatus.OK);
//        }
//        return response;
//    }
//}