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
@Document(collection ="chapters")
public class Chapters {

    @Id
    private String id;
    private String name;
    private Integer number;
    private String urlStream;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapters chapters = (Chapters) o;
        return id.equals(chapters.id) && Objects.equals(name, chapters.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
