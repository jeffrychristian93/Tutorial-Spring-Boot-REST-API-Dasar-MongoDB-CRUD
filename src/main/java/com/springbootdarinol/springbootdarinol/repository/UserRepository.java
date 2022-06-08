package com.springbootdarinol.springbootdarinol.repository;

import com.springbootdarinol.springbootdarinol.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {

}
