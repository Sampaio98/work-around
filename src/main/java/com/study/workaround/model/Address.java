package com.study.workaround.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_name")
    private String name;

    private String number;

    private String observation;

    private String reference;

    @Embedded
    private City city;

//    @Embedded
//    private State state;

    @OneToMany(mappedBy = "address")
    private List<Party> parties;

    public Address() {
        this.parties = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(name, address.name) &&
                Objects.equals(number, address.number) &&
                Objects.equals(observation, address.observation) &&
                Objects.equals(reference, address.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, observation, reference);
    }
}
