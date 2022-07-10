package com.jardelsilva.serie.service.controller;

import com.jardelsilva.serie.service.config.RabbitMQSenderConfig;
import com.jardelsilva.serie.service.dto.SeriesDTO;
import com.jardelsilva.serie.service.model.Series;
import com.jardelsilva.serie.service.service.SeriesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RabbitMQSenderConfig rabbitMQSenderConfig;

    @GetMapping("/{genre}")
    public List<SeriesDTO> listarSeriesPorGenero(@PathVariable(value = "genre") String genre) {
        return seriesService.listarSeriesPorGenero(genre);
    }

    @PostMapping
    public ResponseEntity<?> adicionarSerie(@RequestBody SeriesDTO seriesDTO) {
        SeriesDTO series = seriesService.adicionarSerie(seriesDTO);
        rabbitMQSenderConfig.convertAndSendSeries(series);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
