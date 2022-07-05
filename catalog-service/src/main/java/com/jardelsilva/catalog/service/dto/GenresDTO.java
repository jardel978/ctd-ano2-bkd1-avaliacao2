package com.jardelsilva.catalog.service.dto;

import com.jardelsilva.catalog.service.model.Movies;
import com.jardelsilva.catalog.service.model.Series;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GenresDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private Set<MoviesDTO> movies;
    private Set<SeriesDTO> series;

}
