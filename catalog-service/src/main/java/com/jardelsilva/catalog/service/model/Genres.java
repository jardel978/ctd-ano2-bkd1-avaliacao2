package com.jardelsilva.catalog.service.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="genres")
public class Genres {

    private Set<Movies> movies = new HashSet<>();
    private Set<Series> series = new HashSet<>();

}
