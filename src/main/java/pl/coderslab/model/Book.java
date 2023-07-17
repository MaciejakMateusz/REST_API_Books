package pl.coderslab.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private Long id;
    private String isbn, title, author, publisher, type;


}
