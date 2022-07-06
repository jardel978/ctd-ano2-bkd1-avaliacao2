package com.jardelsilva.serie.service.config;

import com.jardelsilva.serie.service.dto.SeriesDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.api-serie.name}")
    public String serieQueue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void convertAndSendSeries(SeriesDTO seriesDTO) {
        rabbitTemplate.convertAndSend(serieQueue, seriesDTO);
    }

}
