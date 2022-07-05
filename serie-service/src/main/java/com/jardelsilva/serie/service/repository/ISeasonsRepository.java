package com.jardelsilva.serie.service.repository;

import com.jardelsilva.serie.service.model.Seasons;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeasonsRepository extends MongoRepository<Seasons, String> {

}
