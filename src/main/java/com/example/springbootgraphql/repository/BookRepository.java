package com.example.springbootgraphql.repository;

import com.example.springbootgraphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
