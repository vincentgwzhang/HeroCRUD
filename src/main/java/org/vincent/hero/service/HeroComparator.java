package org.vincent.hero.service;

import java.util.Comparator;
import org.vincent.hero.dto.Hero;

public class HeroComparator implements Comparator<Hero>
{
    @Override
    public int compare(Hero o1, Hero o2)
    {
        return o2.getId() - o1.getId();
    }
}
