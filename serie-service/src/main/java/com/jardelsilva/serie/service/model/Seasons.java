package com.jardelsilva.serie.service.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@Document(collection ="seasons")
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