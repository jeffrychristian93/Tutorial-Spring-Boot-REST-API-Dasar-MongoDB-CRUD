package com.springbootdarinol.springbootdarinol.repository;

import com.springbootdarinol.springbootdarinol.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public User create(User request) {
    return mongoTemplate.insert(request, "user");
  }

  @Override
  public User findByIdCustom(String id) {
    User user = mongoTemplate.findById(id, User.class);
    return user;
  }
}
