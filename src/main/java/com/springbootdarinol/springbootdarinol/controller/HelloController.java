package com.springbootdarinol.springbootdarinol.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Hello Controller")
public class HelloController {

  @GetMapping(path = "/hello/{name}")
  @Operation(description = "Sample hello world API")
  public String hello(@PathVariable("name") String name){
    return "Hello " + name + " welcome to programming dari nol..";
  }
}
