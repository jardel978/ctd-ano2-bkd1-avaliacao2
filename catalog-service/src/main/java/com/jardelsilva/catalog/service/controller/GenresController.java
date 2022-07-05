package com.jardelsilva.catalog.service.controller;

import com.jardelsilva.catalog.service.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class GenresController {

    @Autowired
    private GenresService genresService;

    @GetMapping("/{genre}")
    public ResponseEntity<?> listarSeriesPorGenero(@PathVariable(value = "genre") String genre) {
        return ResponseEntity.status(HttpStatus.OK).body(genresService.listarSeriesPorGenero(genre));
    }


}
