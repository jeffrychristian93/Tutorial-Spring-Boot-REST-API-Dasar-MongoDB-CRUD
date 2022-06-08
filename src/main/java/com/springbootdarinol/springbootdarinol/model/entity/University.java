package com.springbootdarinol.springbootdarinol.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "university")
public class University {

  @Id
  private String id;

  private String name;
  private String[] website;
}
