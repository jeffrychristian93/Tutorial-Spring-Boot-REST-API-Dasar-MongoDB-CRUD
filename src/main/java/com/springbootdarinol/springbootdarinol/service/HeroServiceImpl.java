package com.springbootdarinol.springbootdarinol.service;

import com.springbootdarinol.springbootdarinol.model.entity.Hero;
import com.springbootdarinol.springbootdarinol.repository.HeroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImpl implements HeroService {

  @Autowired
  HeroRepository heroRepository;

  @Override
  public List<Hero> daftarHero() {
    return heroRepository.findAll();
  }

  @Override
  public Hero tambahDataHero(Hero request) {
    //save ke mongodb
    heroRepository.save(request);
    return request;
  }

  @Override
  public Boolean updateAtauUbahData(Hero request, String id) {
    final Optional<Hero> result = heroRepository.findById(id);
    if (result.isPresent()) {
      //jika ada/ketemu lakukan update
      result.get().setName(request.getName());
      result.get().setDamage(request.getDamage());
      heroRepository.save(result.get());
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Boolean hapusDataHero(String id) {
    heroRepository.deleteById(id);
    return true;
  }

  @Override
  public Boolean ubahStatus(String id, Boolean isNewHero) {
    final Optional<Hero> result = heroRepository.findById(id);
    if (result.isPresent()) {
      Hero hero = result.get();
      hero.setIsNewHero(isNewHero);
      heroRepository.save(hero);
      return true;
    } else {
      return false;
    }
  }
}
