package com.jardelsilva.movie.service.service;

import com.jardelsilva.movie.service.dto.MovieDTO;
import com.jardelsilva.movie.service.model.Movie;
import com.jardelsilva.movie.service.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IMovieRepository movieRepository;

    public void adicionarMovie(MovieDTO movieDTO) {
        Movie movieModel = modelMapper.map(movieDTO, Movie.class);
        movieRepository.save(movieModel);
    }

}
