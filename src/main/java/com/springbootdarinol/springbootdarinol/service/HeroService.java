package com.springbootdarinol.springbootdarinol.service;

import com.springbootdarinol.springbootdarinol.model.entity.Hero;
import java.util.List;

public interface HeroService {

  List<Hero> daftarHero();
  Hero tambahDataHero(Hero request);
  Boolean updateAtauUbahData(Hero request, String id);
  Boolean hapusDataHero(String id);
  Boolean ubahStatus(String id, Boolean isNewHero);
}
