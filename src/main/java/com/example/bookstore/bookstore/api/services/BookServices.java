package com.example.bookstore.bookstore.api.services;

import com.example.bookstore.bookstore.api.dto.BookDTO;
import com.example.bookstore.bookstore.api.entities.BookEntity;
import com.example.bookstore.bookstore.api.exception.ResourceNotFoundException;
import com.example.bookstore.bookstore.api.repositories.BookRepositories;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServices {

    private final BookRepositories bookRepositories;
    private final ModelMapper modelMapper;

    public BookServices(BookRepositories bookRepositories, ModelMapper modelMapper) {
        this.bookRepositories = bookRepositories;
        this.modelMapper = modelMapper;
    }

    public Optional<BookDTO> getBookById(Long id) {
        // Call the repository method to find the book by ISBN
        return bookRepositories.findById(id)  // Use the correct repository method
                .map(BookEntity -> modelMapper.map(BookEntity, BookDTO.class));
    }

    public List<BookDTO> getAllBooks(){
        List<BookEntity> bookEntities = bookRepositories.findAll();
        return bookEntities
                .stream()
                .map(bookEntity -> modelMapper.map(bookEntity, BookDTO.class))
                .collect(Collectors.toList());
    }

    public BookDTO createNewBook(BookDTO inputBook){
        BookEntity toSaveEntity = modelMapper.map(inputBook, BookEntity.class);
        BookEntity  savedBookEnity = bookRepositories.save(toSaveEntity);
        return modelMapper.map(savedBookEnity, BookDTO.class);
    }

    public BookDTO updateBookById(Long bookId, BookDTO bookDTO){
        isExistsByBookId(bookId);
        BookEntity bookEntity = modelMapper.map(bookDTO, BookEntity.class);
        bookEntity.setId(bookId);
        BookEntity savedBookEntity = bookRepositories.save(bookEntity);
        return modelMapper.map(savedBookEntity, BookDTO.class);
    }

    public void isExistsByBookId(Long bookId){
        boolean exists = bookRepositories.existsById(bookId);
        if(!exists) throw new ResourceNotFoundException("Employee not found with id: "+bookId);
    }

    public boolean deleteBookById(Long bookId){
        isExistsByBookId(bookId);
        bookRepositories.deleteById(bookId);
        return true;
    }
}
