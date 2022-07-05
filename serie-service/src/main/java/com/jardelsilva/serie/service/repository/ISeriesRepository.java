package com.jardelsilva.serie.service.repository;

import com.jardelsilva.serie.service.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeriesRepository extends MongoRepository<Series, String> {

    List<Series> findAllByGenreContains(String genre);

}
