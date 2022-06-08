package com.springbootdarinol.springbootdarinol.service;

import com.springbootdarinol.springbootdarinol.model.dto.UniversityResponse;

public interface UniversityService {

  UniversityResponse[] getUniversity(String countryName);
}
