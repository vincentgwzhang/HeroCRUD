package org.vincent.hero.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.vincent.hero.dto.Hero;

@TestMethodOrder(OrderAnnotation.class)
class HeroServiceTest {

    private HeroService service = new HeroService();

    @Test
    @Order(1)
    void testGetAllHeros() {
        assertThat(service.getAllHeros(), hasSize(9));
    }

    @Test
    @Order(2)
    void testGetHeroById_when_entity_found() {
        Hero hero = service.getHeroById(1);
        assertThat(hero, notNullValue());
    }

    @Test
    @Order(3)
    void testGetHeroById_when_entity_not_found() {
        Hero hero = service.getHeroById(-1);
        assertThat(hero, nullValue());
    }

    @Test
    @Order(4)
    void testUpdateHero() {
        Hero existEntity = new Hero(1, "vincent");
        existEntity = service.updateHero(existEntity);
        assertThat(existEntity, notNullValue());

        Hero notExistEntity = new Hero(-1, "vincent");
        notExistEntity = service.updateHero(notExistEntity);
        assertThat(notExistEntity, nullValue());
    }

    @Test
    @Order(5)
    void testDeleteHero() {
        service.deleteHero(9);
        assertThat(service.getAllHeros(), hasSize(8));

        service.deleteHero(-1);
        assertThat(service.getAllHeros(), hasSize(8));
    }

    @Test
    @Order(6)
    void testCreateHero() {
        Hero createdHero = new Hero(-1, "YanYan 2");
        service.createHero(createdHero);

        assertThat(createdHero.getId(), equalTo(9));
    }

}
