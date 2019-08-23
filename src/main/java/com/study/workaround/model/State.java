package com.study.workaround.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String initials;

    @OneToMany(mappedBy = "state")
    private List<City> cities;

    public State() {
        this.cities = new ArrayList<>();
    }
}
