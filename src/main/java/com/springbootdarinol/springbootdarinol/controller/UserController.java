package com.springbootdarinol.springbootdarinol.controller;

import com.springbootdarinol.springbootdarinol.model.entity.User;
import com.springbootdarinol.springbootdarinol.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping
  @Operation(description = "Rest API untuk menambah data user")
  private User create(@RequestBody User request){
    return userService.create(request);
  }

  @GetMapping(path = "/{id}")
  @Operation(description = "Rest API get data by id")
  private User findById(@PathVariable String id){
    return userService.findById(id);
  }

  @GetMapping(path = "/all")
  @Operation(description = "Rest API get all data")
  private Page<User> findAll(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size){
    return userService.findAll(page, size);
  }

  @PutMapping(path = "/update/{id}")
  @Operation(description = "Rest API update by id")
  private User updateById(@PathVariable String id, @RequestBody User request){
    return userService.update(id, request);
  }

  @DeleteMapping(path = "/delete/{id}")
  @Operation(description = "Rest API delete by id")
  private Boolean deleteById(@PathVariable String id){
    return userService.delete(id);
  }

  @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  @Operation(description = "Rest API UPLOAD FILE")
  private ResponseEntity<String> uploadData(
      @RequestPart FilePart filePart){
    String filename = filePart.filename();
    userService.uploadData(filePart);
    return ResponseEntity.ok("Upload file success! ("+filename+")");
  }
}
