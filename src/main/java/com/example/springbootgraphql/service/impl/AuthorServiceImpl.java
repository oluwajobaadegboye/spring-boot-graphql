package com.example.springbootgraphql.service.impl;

import com.example.springbootgraphql.model.Author;
import com.example.springbootgraphql.repository.AuthorRepository;
import com.example.springbootgraphql.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
}
