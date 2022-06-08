package com.springbootdarinol.springbootdarinol.repository;

import com.springbootdarinol.springbootdarinol.model.entity.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String> {

}
