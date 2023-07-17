package pl.coderslab.services;

import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBook(long id);
    void post(Book book);
    void put(Book book);
    void delete(long id);
}
