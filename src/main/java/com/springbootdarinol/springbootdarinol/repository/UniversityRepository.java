package com.springbootdarinol.springbootdarinol.repository;

import com.springbootdarinol.springbootdarinol.model.entity.University;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversityRepository extends MongoRepository<University, String> {

}
