package com.springbootdarinol.springbootdarinol.service;

import com.springbootdarinol.springbootdarinol.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.http.codec.multipart.FilePart;

public interface UserService {

  User create(User request);

  User findById(String id);

  Page<User> findAll(int page, int size);

  User update(String id, User request);

  boolean delete(String id);

  void uploadData(FilePart filePart);
}
