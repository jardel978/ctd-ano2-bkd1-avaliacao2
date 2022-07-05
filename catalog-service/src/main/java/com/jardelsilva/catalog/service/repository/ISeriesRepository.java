package com.jardelsilva.catalog.service.repository;

import com.jardelsilva.catalog.service.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeriesRepository extends MongoRepository<Series, String> {

}
