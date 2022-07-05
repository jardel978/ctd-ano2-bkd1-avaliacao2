package com.jardelsilva.catalog.service.service;

import com.jardelsilva.catalog.service.dto.MoviesDTO;
import com.jardelsilva.catalog.service.dto.SeriesDTO;
import com.jardelsilva.catalog.service.model.Movies;
import com.jardelsilva.catalog.service.model.Series;
import com.jardelsilva.catalog.service.repository.*;
import com.jardelsilva.catalog.service.repository.feing.ISeriesFeing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenresService {

    @Autowired
    private IChaptersRepository chaptersRepository;

    @Autowired
    private IGenresRepository genresRepository;

    @Autowired
    private IMoviesRepository moviesRepository;

    @Autowired
    private ISeasonsRepository seasonsRepository;

    @Autowired
    private ISeriesRepository seriesRepository;

    @Autowired
    private ISeriesFeing seriesFeing;

    @Autowired
    private ModelMapper modelMapper;

    public void adicionarSerie(SeriesDTO seriesDTO) {
        Series seriesModel = modelMapper.map(seriesDTO, Series.class);
        seriesRepository.save(seriesModel);
    }

    public void adicionarMovie(MoviesDTO moviesDTO) {
        Movies moviesModel = modelMapper.map(moviesDTO, Movies.class);
        moviesRepository.save(moviesModel);
    }

    public Object listarSeriesPorGenero(String genre) {
        return seriesFeing.getMovieByGenre(genre);
    }

}
