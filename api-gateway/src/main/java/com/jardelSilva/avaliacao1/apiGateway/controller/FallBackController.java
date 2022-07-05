package com.jardelSilva.avaliacao1.apiGateway.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @CircuitBreaker(name = "movieService")
    @GetMapping("/movies")
    public ResponseEntity<String> movieFallback() {
        return new ResponseEntity<>("Servidor de filmes indisponível. Por favor, contate o suporte.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CircuitBreaker(name = "serieService")
    @GetMapping("/series")
    public ResponseEntity<String> serieFallback() {
        return new ResponseEntity<>("Servidor de catálogos indisponível. Por favor, contate o suporte.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CircuitBreaker(name = "catalogService")
    @GetMapping("/catalog")
    public ResponseEntity<String> catalogFallback() {
        return new ResponseEntity<>("Servidor de catálogos indisponível. Por favor, contate o suporte.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}