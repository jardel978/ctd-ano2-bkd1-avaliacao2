package com.jardelsilva.movie.service.repository;

import com.jardelsilva.movie.service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, String> {

}
