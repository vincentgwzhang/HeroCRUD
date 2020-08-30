package org.vincent.hero.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.vincent.hero.dto.Hero;

@Service
public class HeroService
{
    private static List<Hero> heroList = new ArrayList<>();

    static {
        heroList.add(new Hero(1, "name1"));
        heroList.add(new Hero(2, "name2"));
        heroList.add(new Hero(3, "name3"));
        heroList.add(new Hero(4, "name4"));
        heroList.add(new Hero(5, "name5"));
        heroList.add(new Hero(6, "name6"));
        heroList.add(new Hero(7, "name7"));
        heroList.add(new Hero(8, "name8"));
        heroList.add(new Hero(9, "name9"));
    }

    public List<Hero> getAllHeros() {
        return heroList;
    }

    public Hero getHeroById(final Integer heroID) {
        return heroList.stream().filter(hero -> hero.getId() == heroID).findAny().get();
    }

    public void updateHero(final Hero hero) {
        Optional<Hero> heroOptional = heroList.stream().filter(hero1 -> hero1.getId() == hero.getId()).findFirst();
        heroOptional.ifPresent(
            _hero -> {
                _hero.setName(hero.getName());
            }
        );
    }

    public void deleteHero(final Integer heroID) {
        Optional<Hero> heroOptional = heroList.stream().filter(hero1 -> hero1.getId() == heroID).findFirst();
        heroOptional.ifPresent(
                _hero -> {
                    heroList.remove(_hero);
                }
        );
    }

    public Hero createHero(final Hero hero) {
        heroList.sort(new HeroComparator());
        if (heroList.isEmpty()) {
            hero.setId(0);
        } else {
            Hero lastHero = heroList.get(0);
            hero.setId(lastHero.getId()+1);
        }
        heroList.add(hero);
        return hero;
    }

}
