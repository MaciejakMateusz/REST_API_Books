package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.services.MockBookService;
import java.util.List;


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
        return mockBookService.getAllBooks();
    }

    @PostMapping()
    public void postBook(@RequestBody Book book) {
        mockBookService.post(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return mockBookService.getBook(id);
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