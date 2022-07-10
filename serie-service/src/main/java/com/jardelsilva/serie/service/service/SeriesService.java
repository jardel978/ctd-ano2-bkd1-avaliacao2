package com.jardelsilva.serie.service.service;

import com.jardelsilva.serie.service.dto.SeriesDTO;
import com.jardelsilva.serie.service.model.Chapters;
import com.jardelsilva.serie.service.model.Seasons;
import com.jardelsilva.serie.service.model.Series;
import com.jardelsilva.serie.service.repository.IChaptersRepository;
import com.jardelsilva.serie.service.repository.ISeasonsRepository;
import com.jardelsilva.serie.service.repository.ISeriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SeriesService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ISeriesRepository seriesRepository;

    @Autowired
    private ISeasonsRepository seasonsRepository;

    @Autowired
    private IChaptersRepository chaptersRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SeriesDTO> listarSeriesPorGenero(String genre) {
        List<Series> series = seriesRepository.findAllByGenreContains(genre);
        return series.stream().map(serie -> modelMapper.map(serie, SeriesDTO.class)).collect(Collectors.toList());
    }

    public SeriesDTO adicionarSerie(SeriesDTO seriesDTO) {
        log.info(restTemplate.getForObject("http://serie-service:8085/series/", String.class));
        Series seriesModel = modelMapper.map(seriesDTO, Series.class);

        Set<Seasons> seasonsSet = seriesDTO.getSeasons().stream().map(seasonsDTO -> {
            Seasons seasonsModel = modelMapper.map(seasonsDTO, Seasons.class);
            Set<Chapters> chaptersSet = seasonsDTO.getChapters().stream().map(chapterDTO -> {
                Chapters chaptersModel = modelMapper.map(chapterDTO, Chapters.class);
                return chaptersRepository.save(chaptersModel);
            }).collect(Collectors.toSet());
            seasonsModel.setChapters(chaptersSet);
            return seasonsRepository.save(seasonsModel);
        }).collect(Collectors.toSet());
        seriesModel.setSeasons(seasonsSet);
        Series seriesBase = seriesRepository.save(seriesModel);
        return modelMapper.map(seriesBase, SeriesDTO.class);
    }


}
