package com.jardelsilva.catalog.service.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "genres")
public class Genres {

    private List<Movies> movies = new ArrayList<>();
    private List<Series> series = new ArrayList<>();

}
