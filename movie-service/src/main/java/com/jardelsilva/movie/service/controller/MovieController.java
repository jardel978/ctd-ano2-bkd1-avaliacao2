package com.jardelsilva.movie.service.controller;

import com.jardelsilva.movie.service.config.RabbitMQSenderConfig;
import com.jardelsilva.movie.service.dto.MovieDTO;
import com.jardelsilva.movie.service.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private RabbitMQSenderConfig rabbitMQSenderConfig;

    @PostMapping
    public ResponseEntity<?> adicionarMovie(@RequestBody MovieDTO movieDTO) {
        movieService.adicionarMovie(movieDTO);
        rabbitMQSenderConfig.convertAndSendMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
