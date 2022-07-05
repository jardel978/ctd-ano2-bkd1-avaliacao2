package com.jardelsilva.catalog.service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "seasons")
public class Seasons {

    @Id
    private String id;
    private String seasonNumber;
    private Set<Chapters> chapters = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seasons seasons = (Seasons) o;
        return id.equals(seasons.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
