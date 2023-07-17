package pl.coderslab.services;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BooksRepository;

import java.util.*;

@Service
public class MockBookService implements BookService {

    private final BooksRepository booksRepository;
    public MockBookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    private static Long nextId = 4L;

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.getList();
    }

    @Override
    public Optional<Book> getBook(long id) {
        return booksRepository.getList().stream()
                        .filter(book -> book.getId() == id)
                        .findFirst();
    }

    @Override
    public void post(Book book) {
        book.setId(nextId);
        booksRepository.getList().add(book);
        nextId++;
    }

    @Override
    public void put(Book book) {
        List<Book> books = booksRepository.getList();
                    books.removeIf(b -> Objects.equals(b.getId(), book.getId()));
                    books.add(book);
                    books.sort(Comparator.comparing(Book::getId));
    }

    @Override
    public void delete(long id) {
        Optional<List<Book>> optionalBooks = Optional.ofNullable(booksRepository.getList());
        optionalBooks.ifPresent(books -> books.removeIf(book -> book.getId() == id));
    }
}
