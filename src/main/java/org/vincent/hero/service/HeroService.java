package org.vincent.hero.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.vincent.hero.dto.Hero;

@Service
public class HeroService
{
    private static final List<Hero> heroList = new ArrayList<>();

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
        return heroList.stream().filter(hero -> hero.getId().equals(heroID)).findAny().orElse(null);
    }

    public Hero updateHero(final Hero hero) {
        Optional<Hero> heroOptional = heroList.stream().filter(hero1 -> hero1.getId().equals(hero.getId())).findFirst();
        if (heroOptional.isPresent()) {
            heroOptional.get().setName(hero.getName());
            return heroOptional.get();
        } else {
            return null;
        }
    }

    public void deleteHero(final Integer heroID) {
        Optional<Hero> heroOptional = heroList.stream().filter(hero1 -> hero1.getId().equals(heroID)).findFirst();
        heroOptional.ifPresent(heroList::remove);
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
