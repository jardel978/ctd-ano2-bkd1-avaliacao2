package com.jardelsilva.serie.service.dto;

import com.jardelsilva.serie.service.model.Seasons;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class SeriesDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private String id;
    private String name;
    private String genre;
    private Set<SeasonsDTO> seasons;

}
