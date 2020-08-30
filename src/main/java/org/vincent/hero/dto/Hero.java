package org.vincent.hero.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Hero
{
    private Integer id;

    private String name;

    public Hero(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Hero hero = (Hero) o;
        return Objects.equal(id, hero.id) && Objects.equal(name, hero.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id, name);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("id", id).add("name", name).toString();
    }
}
