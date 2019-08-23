package com.study.workaround.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class City {

    @Column(name = "city_name")
    private String name;

    @Embedded
    private State state;

    public City() {
    }
}
