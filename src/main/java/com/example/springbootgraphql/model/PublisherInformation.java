package com.example.springbootgraphql.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherInformation {
    @Id
    @GeneratedValue
    private Long id;
    private String publisherName;
    private LocalDate publishDate;
}
