package com.jardelsilva.movie.service.config;

import com.jardelsilva.movie.service.dto.MovieDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.api-movie.name}")
    public String movieQueue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void convertAndSendMovie(MovieDTO movieDTO) {
        rabbitTemplate.convertAndSend(movieQueue, movieDTO);
    }

}
