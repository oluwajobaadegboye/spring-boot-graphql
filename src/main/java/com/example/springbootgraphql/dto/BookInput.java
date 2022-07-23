package com.example.springbootgraphql.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookInput {
    private String name;
    private String publisher;
    private Long authorId;
}
