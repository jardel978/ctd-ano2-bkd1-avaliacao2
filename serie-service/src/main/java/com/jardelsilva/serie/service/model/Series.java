package com.jardelsilva.serie.service.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@Document(collection = "series")
public class Series {

    @Id
    private String id;
    private String name;
    private String genre;
    private Set<Seasons> seasons = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return id.equals(series.id) && Objects.equals(name, series.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
