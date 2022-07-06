package com.jardelsilva.catalog.service.repository.feing;

import com.jardelsilva.catalog.service.dto.SeriesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "serie-service", url = "api-gateway:8080/series")
public interface ISeriesFeing {

    @GetMapping("/{genre}")
    List<SeriesDTO> getSeriesByGenre(@PathVariable(value = "genre") String genre);

}
