package com.example.bookstore.bookstore.api.dto;


import com.example.bookstore.bookstore.api.annotation.BookFormatValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;

    @NotNull
    private String isbn;

    @NotBlank(message = "Title of the book cannot be blank")
    private String title;

    @NotBlank(message = "AuthorName of the book cannot be blank")
    private String authorName;

    @NotBlank(message = "Publisher of the book cannot be blank")
    private String publisher;

    @PastOrPresent(message = "Publish Date cannot be in future")
    private LocalDate publishDate;

//    @Pattern(regexp = "^(PAPER|PDF)$")
    @BookFormatValidation
    private String format;

    @NotNull(message = "Price cannot be Null")
    @Positive(message = "Price of book can only be Positive")
    @DecimalMin(value = "50.50")
    private Double price;
    private Integer rating;
    private String genre;

}
