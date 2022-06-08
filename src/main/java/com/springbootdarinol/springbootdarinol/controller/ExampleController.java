package com.springbootdarinol.springbootdarinol.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contoh")
public class ExampleController {

  @Value("${contoh.data.string}")
  String dataString;

  @Value("${contoh.data.integer}")
  int dataInteger;

  @Value("${contoh.data.boolean}")
  boolean dataBool;

  @Value("#{'${contoh.data.list}'.split(',')}")
  List<String> dataList;

  @GetMapping(path = "/{id}")
  public ResponseEntity<Object> getProperties(@PathVariable String id){
    Object result;

    if (id.equals("1")) {
      result = dataString;
    } else if (id.equals("2")){
      result = dataInteger;
    } else if (id.equals("3")){
      result = dataBool;
    } else if (id.equals("4")) {
      result = dataList;
    } else {
      result = "Not Found!";
    }

    return ResponseEntity.ok().body(result);
  }

}
