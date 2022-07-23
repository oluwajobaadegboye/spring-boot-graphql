package com.example.springbootgraphql;

import com.example.springbootgraphql.model.Author;
import com.example.springbootgraphql.model.Book;
import com.example.springbootgraphql.repository.AuthorRepository;
import com.example.springbootgraphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootGraphqlApplication implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Author authorJoba = authorRepository.save(
                Author.builder().name("Oluwajoba").build()
        );
        Author authorSolomon = authorRepository.save(
                Author.builder().name("Solomon").build()
        );

        bookRepository.saveAll(
                List.of(
                        Book.builder().name("Book 1").author(authorJoba).publisher("Publisher 1").build(),
                        Book.builder().name("Book 2").author(authorJoba).publisher("Publisher 1").build(),
                        Book.builder().name("Book 3").author(authorSolomon).publisher("Publisher 2").build(),
                        Book.builder().name("Book 4").author(authorSolomon).publisher("Publisher 2").build()
                )
        );
    }
}
