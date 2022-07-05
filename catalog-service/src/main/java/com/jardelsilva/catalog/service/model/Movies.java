package com.jardelsilva.catalog.service.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
public class Movies {

    @Id
    private String id;
    private String name;
    private String genre;
    private String urlStream;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return id.equals(movies.id) && name.equals(movies.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
