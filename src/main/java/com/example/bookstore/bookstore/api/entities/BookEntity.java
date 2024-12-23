package com.example.bookstore.bookstore.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)  // Ensure ISBN is unique and not null
    private String isbn;  // ISBN should be a String, not a Long

    private String title;
    private String authorName;
    private String publisher;
    private LocalDate publishDate;
    private String format;
    private Double price;
    private Integer rating;
    private String genre;
}
