package com.jardelsilva.serie.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class ChaptersDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private String id;
    private String name;
    private Integer number;
    private String urlStream;

}
