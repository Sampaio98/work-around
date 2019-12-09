package com.study.workaround.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Address {

    @EqualsAndHashCode.Include
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

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<Party> parties;

    public Address() {
        this.parties = new ArrayList<>();
    }
}
