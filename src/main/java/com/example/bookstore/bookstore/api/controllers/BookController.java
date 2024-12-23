package com.example.bookstore.bookstore.api.controllers;


import com.example.bookstore.bookstore.api.dto.BookDTO;
import com.example.bookstore.bookstore.api.exception.ResourceNotFoundException;
import com.example.bookstore.bookstore.api.services.BookServices;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.bookstore.bookstore.api.dto.BookDTO.*;

@RestController
@RequestMapping(path = "/books")
public class BookController {


    private final BookServices bookServices;


    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable(name = "bookId") Long id){
        Optional<BookDTO> bookDTO = bookServices.getBookById(id);
        return bookDTO
                .map(bookDTO1 -> ResponseEntity.ok(bookDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Book Not found with id: "+id));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooKS(@RequestParam(required = false, name = "rating") Integer rating,
                                                     @RequestParam(required = false)  String sortBy){
            return ResponseEntity.ok(bookServices.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createNewBook(@RequestBody @Valid BookDTO inputBook){
        BookDTO savedBook = bookServices.createNewBook(inputBook);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

}
