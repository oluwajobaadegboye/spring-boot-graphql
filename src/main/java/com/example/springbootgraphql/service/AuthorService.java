package com.example.springbootgraphql.service;

import com.example.springbootgraphql.model.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> getAllAuthors();
    public Optional<Author> getAuthorById(Long authorId);

    public Author addAuthor(Author author);
}
