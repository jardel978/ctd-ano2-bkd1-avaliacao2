package com.jardelsilva.catalog.service.repository;

import com.jardelsilva.catalog.service.dto.MoviesDTO;
import com.jardelsilva.catalog.service.model.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoviesRepository extends MongoRepository<Movies, String> {

    List<MoviesDTO> findAllByGenreContains(String genre);

}
