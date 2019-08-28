package com.study.workaround.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class City {

    @Column(name = "city_id")
    private Long id;

    @Column(name = "city_name")
    private String name;

    @Embedded
    private State state;

    public City() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
