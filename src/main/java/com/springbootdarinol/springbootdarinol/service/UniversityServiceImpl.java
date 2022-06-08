package com.springbootdarinol.springbootdarinol.service;

import com.springbootdarinol.springbootdarinol.model.dto.UniversityResponse;
import com.springbootdarinol.springbootdarinol.model.entity.University;
import com.springbootdarinol.springbootdarinol.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UniversityServiceImpl implements UniversityService{

  @Autowired
  UniversityRepository universityRepository;

  @Override
  public UniversityResponse[] getUniversity(String countryName) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<UniversityResponse[]> response = restTemplate.getForEntity(
        "http://universities.hipolabs.com/search?country="+countryName,
        UniversityResponse[].class);
    UniversityResponse[] body = response.getBody();
    if (body.length > 0) {
      //simpan data ke database
      for (UniversityResponse universityResponse : body) {
        University university = new University(null, universityResponse.getName(),
            universityResponse.getWebsite());

        universityRepository.save(university);
      }
    }
    return body;
  }
}
