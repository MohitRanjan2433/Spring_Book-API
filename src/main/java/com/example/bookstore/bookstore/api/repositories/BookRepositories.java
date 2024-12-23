package com.example.bookstore.bookstore.api.repositories;


import com.example.bookstore.bookstore.api.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositories extends JpaRepository<BookEntity, Long> {
}
