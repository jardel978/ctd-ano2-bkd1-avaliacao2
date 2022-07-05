package com.jardelsilva.catalog.service.repository;

import com.jardelsilva.catalog.service.model.Genres;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenresRepository extends MongoRepository<Genres, String> {

}
