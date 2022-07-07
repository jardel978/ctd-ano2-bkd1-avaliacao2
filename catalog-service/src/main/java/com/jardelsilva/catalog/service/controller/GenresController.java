package com.jardelsilva.catalog.service.controller;

import com.jardelsilva.catalog.service.dto.GenresDTO;
import com.jardelsilva.catalog.service.dto.MoviesDTO;
import com.jardelsilva.catalog.service.dto.SeriesDTO;
import com.jardelsilva.catalog.service.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class GenresController {

    @Autowired
    private GenresService genresService;

//    @Value("${message}")
//    public String message;

    @GetMapping("/{genre}")
    public ResponseEntity<?> listarSeriesMoviesPorGenero(@PathVariable(value = "genre") String genre) {
        List<SeriesDTO> seriesDTOList = genresService.listarSeriesPorGenero(genre);
        List<MoviesDTO> moviesDTOList = genresService.listarMoviesPorGenero(genre);
        GenresDTO genresDTO = GenresDTO.builder()
                .movies(moviesDTOList)
                .series(seriesDTOList)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(genresDTO);
    }

//    @GetMapping
//    public String test() {
//        return message;
//    }


}
