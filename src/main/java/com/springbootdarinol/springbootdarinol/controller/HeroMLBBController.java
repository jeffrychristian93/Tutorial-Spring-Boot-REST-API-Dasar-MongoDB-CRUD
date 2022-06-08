package com.springbootdarinol.springbootdarinol.controller;

import com.springbootdarinol.springbootdarinol.model.entity.Hero;
import com.springbootdarinol.springbootdarinol.service.HeroService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hero")
@Api(value = "Hero Controller")
public class HeroMLBBController {

  HeroService heroService;

  @Autowired
  public HeroMLBBController(HeroService heroService) {
    this.heroService = heroService;
  }


  @GetMapping(path = "/daftar-hero")
  @Operation(description = "API untuk melihat daftar hero")
  public List<Hero> daftarHero(){
    return heroService.daftarHero();
  }

  @PostMapping(path = "/tambah")
  @Operation(description = "API untuk menambah data hero")
  public Hero tambahDataHero(@RequestBody Hero request){
    return heroService.tambahDataHero(request);
  }

  @PutMapping(path = "/ubah/{id}")
  @Operation(description = "API untuk ubah data hero by ID")
  public Boolean updateAtauUbahData(@RequestBody Hero request, @PathVariable String id){
    return heroService.updateAtauUbahData(request, id);
  }

  @DeleteMapping(path = "/hapus/{id}")
  @Operation(description = "API untuk hapus data hero by ID")
  public Boolean hapusDataHero(@PathVariable String id){
    return heroService.hapusDataHero(id);
  }

  @PatchMapping(path = "/ubah-status/{id}")
  @Operation(description = "API untuk ubah status hero")
  public Boolean ubahStatus(@PathVariable String id, @RequestParam Boolean isNewHero){
    return heroService.ubahStatus(id, isNewHero);
  }
}
