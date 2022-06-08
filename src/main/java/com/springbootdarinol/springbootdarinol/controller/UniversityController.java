package com.springbootdarinol.springbootdarinol.controller;

import com.springbootdarinol.springbootdarinol.model.dto.UniversityResponse;
import com.springbootdarinol.springbootdarinol.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university")
public class UniversityController {

  @Autowired
  UniversityService universityService;

  @GetMapping("/{countryName}")
  public UniversityResponse[] getUniversity(@PathVariable String countryName){
    final UniversityResponse[] responses = universityService.getUniversity(countryName);
    return responses;
  }
}
