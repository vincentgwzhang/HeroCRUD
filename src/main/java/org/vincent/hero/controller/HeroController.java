package org.vincent.hero.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vincent.hero.dto.Hero;
import org.vincent.hero.service.HeroService;

@CrossOrigin
@RestController
public class HeroController
{
    @Autowired
    private HeroService heroService;

    @GetMapping("/api/heroes")
    public List<Hero> getHeroes() {
        return heroService.getAllHeros();
    }

    @GetMapping("/api/heroes/{id}")
    public Hero getHero(@PathVariable("id") Integer id) {
        return heroService.getHeroById(id);
    }

    @PutMapping("/api/hero")
    public void updateHero(@RequestBody Hero hero) {
        heroService.updateHero(hero);
    }

    @PostMapping("/api/hero")
    public Hero createHero(@RequestBody Hero hero) {
        return heroService.createHero(hero);
    }

    @DeleteMapping("/api/hero/{id}")
    public void deleteHero(@PathVariable("id") int heroID) {
        heroService.deleteHero(heroID);
    }
}
