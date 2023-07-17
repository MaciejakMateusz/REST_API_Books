package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Book;
import pl.coderslab.services.MockBookService;

import java.util.List;
import java.util.Optional;

/**
 * GET	/books	Zwraca listę wszystkich książek.
 * POST	/books	Tworzy nową książkę na podstawie danych przekazanych z formularza i zapisuje ją do bazy danych.
 * GET	/books/{id}	Wyświetla informacje o książce o podanym id.
 * PUT	/books	Zmienia informacje o książce o podanym id na nową.
 * DELETE	/books/{id}	Usuwa książkę o podanym id z bazy danych.
 **/


@RestController
@RequestMapping("/books")
public class BookController {

    private final MockBookService mockBookService;
    @Autowired
    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @GetMapping()
    public List<Book> allBooks() {
        Optional<List<Book>> optionalBooks = Optional.ofNullable(mockBookService.getAllBooks());
        return optionalBooks.orElseThrow(() -> new NotFoundException("Books not found"));
    }

    @PostMapping()
    public void postBook(@RequestBody Book book) {
        mockBookService.post(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        Optional<Book> optionalBook = mockBookService.getBook(id);
        return optionalBook.orElseThrow(() -> new NotFoundException("Book not found"));
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable long id) {
        mockBookService.delete(id);
    }

    @PutMapping()
    public void updateBook(@RequestBody Book book) {
        mockBookService.put(book);
    }

}