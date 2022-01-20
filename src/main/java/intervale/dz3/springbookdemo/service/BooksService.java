package intervale.dz3.springbookdemo.service;

import intervale.dz3.springbookdemo.model.Book;

import java.util.List;

public interface BooksService {
    /**
     * Создает нового клиента
     * @param book - клиент для создания
     */

    void createBook(Book book);
    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */

    List<Book> getAllBooks();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */

    Book read(int id);
    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param book - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */

    boolean updateBooks(Book book, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);
}
