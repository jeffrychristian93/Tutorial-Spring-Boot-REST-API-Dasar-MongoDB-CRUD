package com.springbootdarinol.springbootdarinol.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityResponse {

  @JsonProperty("name")
  private String name;

  @JsonProperty("web_pages")
  private String[] website;
}
