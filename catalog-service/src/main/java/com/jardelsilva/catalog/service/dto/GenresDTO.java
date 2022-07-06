package com.jardelsilva.catalog.service.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GenresDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private List<MoviesDTO> movies;
    private List<SeriesDTO> series;

}
