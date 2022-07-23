package com.example.springbootgraphql.controller;

import com.example.springbootgraphql.dto.BookInput;
import com.example.springbootgraphql.model.Author;
import com.example.springbootgraphql.model.Book;
import com.example.springbootgraphql.repository.BookRepository;
import com.example.springbootgraphql.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {

    //TODO: This should be a service by convention
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @QueryMapping
    List<Book> books(){
        return bookRepository.findAll();
    }

    @QueryMapping
    Optional<Book> bookById(@Argument Long id){
        return bookRepository.findById(id);
    }

    @MutationMapping
    public Book addBook(@Argument BookInput bookInput) {
        Author author = authorService.getAuthorById(bookInput.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found"));

        return bookRepository.save(
                Book.builder()
                        .author(author)
                        .name(bookInput.getName())
                        .publisher(bookInput.getPublisher())
                        .build()
        );
    }

//    @MutationMapping
//    public Book updateBook(@Argument Long id, @Argument BookInput book) {
//
//    }
//
//    public void deleteBook(@Argument Long id) {
//
//    }
}
