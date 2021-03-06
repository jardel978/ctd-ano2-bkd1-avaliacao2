package com.jardelsilva.catalog.service.service;

import com.jardelsilva.catalog.service.dto.MoviesDTO;
import com.jardelsilva.catalog.service.dto.SeriesDTO;
import com.jardelsilva.catalog.service.model.Chapters;
import com.jardelsilva.catalog.service.model.Movies;
import com.jardelsilva.catalog.service.model.Seasons;
import com.jardelsilva.catalog.service.model.Series;
import com.jardelsilva.catalog.service.repository.*;
import com.jardelsilva.catalog.service.repository.feing.ISeriesFeing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        seriesModel.getSeasons().forEach(season -> {
            season.getChapters().forEach(chapter -> chaptersRepository.save(modelMapper.map(chapter, Chapters.class)));
            seasonsRepository.save(modelMapper.map(season, Seasons.class));
        });
        seriesRepository.save(seriesModel);
    }

    public void adicionarMovie(MoviesDTO moviesDTO) {
        Movies moviesModel = modelMapper.map(moviesDTO, Movies.class);
        moviesRepository.save(moviesModel);
    }

    public List<SeriesDTO> listarSeriesPorGenero(String genre) {
        return seriesFeing.getSeriesByGenre(genre);
    }

    public List<MoviesDTO> listarMoviesPorGenero(String genre) {
        return moviesRepository.findAllByGenreContains(genre);
    }

}
