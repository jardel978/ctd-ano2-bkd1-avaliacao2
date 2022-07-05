package com.jardelsilva.serie.service.repository;

import com.jardelsilva.serie.service.model.Chapters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChaptersRepository extends MongoRepository<Chapters, String> {

}
