package com.example.springbootgraphql.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String publisher;
//    @OneToOne(fetch = FetchType.LAZY)
//    private PublisherInformation publisherInformation;
    @OneToOne(fetch = FetchType.LAZY)
    private Author author;
}
