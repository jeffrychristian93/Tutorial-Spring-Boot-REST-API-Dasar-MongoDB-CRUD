package com.springbootdarinol.springbootdarinol.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hero")
public class Hero {

  //unique identifier
  @Id
  private String id;
  private String name;
  private int damage;
  private Boolean isNewHero;

}
