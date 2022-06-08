package com.springbootdarinol.springbootdarinol.service;

import com.springbootdarinol.springbootdarinol.model.entity.User;
import com.springbootdarinol.springbootdarinol.repository.UserRepository;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public User create(User request) {
    return userRepository.save(request);
  }

  @Override
  public User findById(String id) {
    User result = userRepository.findByIdCustom(id);
    if (result != null) {
      return result;
    } else {
      //throw No Data Exist
      return null;
    }
  }

  @Override
  public Page<User> findAll(int page, int size) {
    PageRequest request = PageRequest.of(page, size, Sort.by("name").ascending());
    Page<User> result = userRepository.findAll(request);
    return result;
  }

  @Override
  public User update(String id, User request) {
    Optional<User> result = userRepository.findById(id);
    if (result.isPresent()) {
      //lakukan update data
      result.get().setName(request.getName());
      result.get().setGender(request.getGender());
      return userRepository.save(result.get());
    } else {
      //ignore
      throw new ExceptionInInitializerError("Data Not Found");
    }
  }

  @Override
  public boolean delete(String id) {
    userRepository.deleteById(id);
    return true;
  }

  @Override
  public void uploadData(FilePart filePart) {
    String CSV_SPLIT_REGEX = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    filePart.content()
        .map(DataBuffer::asInputStream)
        .map(inputStream -> {
          try {
            return inputStream.readAllBytes();
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        })
        .map(String::new)
        .flatMapIterable(data -> {
          List<String> strings = Arrays.stream(data.split("\n")).collect(Collectors.toList());
          String header = strings.remove(0);
          return strings;
        })
        .map(data -> data.trim().split(CSV_SPLIT_REGEX))
        .doOnNext(columns -> {
          String name = columns[0];
          String gender = columns[1];
          User user = new User();
          user.setName(name);
          user.setGender(gender);
          create(user);
        })
        .subscribe();
  }
}
