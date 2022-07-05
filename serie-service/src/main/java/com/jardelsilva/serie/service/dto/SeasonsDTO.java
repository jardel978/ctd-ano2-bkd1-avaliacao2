package com.jardelsilva.serie.service.dto;

import com.jardelsilva.serie.service.model.Chapters;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SeasonsDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private String id;
    private String seasonNumber;
    private Set<ChaptersDTO> chapters;

}
