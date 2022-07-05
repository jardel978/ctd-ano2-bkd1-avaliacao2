package com.jardelsilva.catalog.service.repository;

import com.jardelsilva.catalog.service.model.Chapters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChaptersRepository extends MongoRepository<Chapters, String> {

}
