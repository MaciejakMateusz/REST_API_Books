package pl.coderslab.services;

import pl.coderslab.model.Book;

import java.util.List;
public interface BookService {
    List<Book> getAllBooks();
    Book getBook(long id);
    void post(Book book);
    void put(Book book);
    void delete(long id);
}
