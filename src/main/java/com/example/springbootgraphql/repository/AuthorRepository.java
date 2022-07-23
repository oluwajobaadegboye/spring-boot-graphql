package com.example.springbootgraphql.repository;

import com.example.springbootgraphql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
