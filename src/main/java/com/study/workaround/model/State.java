package com.study.workaround.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class State implements Comparable<State> {

    @EqualsAndHashCode.Include
    @JsonProperty("id")
    @Column(name = "state_id")
    private Long id;

    @JsonProperty("nome")
    @Column(name = "state_name")
    private String name;

    @JsonProperty("sigla")
    @Column(name = "state_initials")
    private String initials;

    @Override
    public int compareTo(State o) {
        return this.name.compareTo(o.getName());
    }
}
