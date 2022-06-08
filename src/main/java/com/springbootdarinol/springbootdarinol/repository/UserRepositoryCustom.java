package com.springbootdarinol.springbootdarinol.repository;

import com.springbootdarinol.springbootdarinol.model.entity.User;

public interface UserRepositoryCustom {

  User create(User request);

  User findByIdCustom(String id);
}
