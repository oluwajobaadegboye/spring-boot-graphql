package com.example.springbootgraphql.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorInput {
    private String name;
    private List<BookInput> bookInputList;
}
