package com.example.springbootgraphql.controller;

import com.example.springbootgraphql.dto.AuthorInput;
import com.example.springbootgraphql.dto.BookInput;
import com.example.springbootgraphql.model.Author;
import com.example.springbootgraphql.model.Book;
import com.example.springbootgraphql.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @QueryMapping
    List<Author> authors(){
        return authorService.getAllAuthors();
    }

    @QueryMapping(name = "authorById")
    Optional<Author> getAuthorById(@Argument Long id){
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public Author addAuthor(@Argument AuthorInput authorInput) {
      return authorService.addAuthor(
                Author.builder()
                        .name(authorInput.getName())
                        //TODO: This can be better modified to accept bookIds in case book is created already
                        .books(
                                getBook(authorInput.getBookInputList())
                        )
                        .build());
    }

    private List<Book> getBook(List<BookInput> bookInputList) {
        return bookInputList.stream().map(bookInput ->
                        Book.builder()
                                .publisher(bookInput.getPublisher())
                                .name(bookInput.getName())
                                .build()
                ).collect(Collectors.toList());
    }


}
