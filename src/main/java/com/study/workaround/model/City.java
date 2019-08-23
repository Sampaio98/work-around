package com.study.workaround.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private State state;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;

    public City() {
        this.addresses = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name) &&
                Objects.equals(state, city.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state);
    }
}
