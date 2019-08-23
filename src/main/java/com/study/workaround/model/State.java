package com.study.workaround.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class State {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "state_name")
    private String name;

    @Column(name = "state_initials")
    private String initials;

//    @OneToMany(mappedBy = "state")
//    private List<City> cities;

    public State() {
//        this.cities = new ArrayList<>();
    }
}
