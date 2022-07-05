package com.jardelsilva.catalog.service.rabbit;

import com.jardelsilva.catalog.service.dto.MoviesDTO;
import com.jardelsilva.catalog.service.dto.SeriesDTO;
import com.jardelsilva.catalog.service.service.GenresService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CatalogListner {
    // vai ouvir as mensagens postadas para a fila
    @Autowired
    private GenresService genresService;

    @RabbitListener(queues = {"${queues.api-serie.name}"})
    public void receiveSeriesMessage(@Payload SeriesDTO seriesDTO) {
        genresService.adicionarSerie(seriesDTO);
    }

    @RabbitListener(queues = {"${queues.api-movie.name}"})
    public void receiveSeriesMessage(@Payload MoviesDTO moviesDTO) {
        genresService.adicionarMovie(moviesDTO);
    }

}
