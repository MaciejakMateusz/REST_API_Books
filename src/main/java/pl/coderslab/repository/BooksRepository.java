package pl.coderslab.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@Getter
public class BooksRepository {

    private final List<Book> list;

    public BooksRepository() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }
}
