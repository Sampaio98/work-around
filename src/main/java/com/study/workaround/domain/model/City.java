package com.study.workaround.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Embeddable
public class City {

    @EqualsAndHashCode.Include
    @Column(name = "city_id")
    private Long id;

    @Column(name = "city_name")
    private String name;

    @Embedded
    private State state;

}
