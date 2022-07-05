package com.jardelsilva.catalog.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private String id;
    private String name;
    private String genre;
    private String urlStream;

}
