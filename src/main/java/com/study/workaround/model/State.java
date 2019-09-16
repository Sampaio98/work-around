package com.study.workaround.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class State implements Comparable<State> {

    @JsonProperty("id")
    @Column(name = "state_id")
    private Long id;

    @JsonProperty("nome")
    @Column(name = "state_name")
    private String name;

    @JsonProperty("sigla")
    @Column(name = "state_initials")
    private String initials;

    public State() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;
        return Objects.equals(id, state.id) &&
                Objects.equals(name, state.name) &&
                Objects.equals(initials, state.initials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, initials);
    }

    @Override
    public int compareTo(State o) {
        return this.name.compareTo(o.getName());
    }
}
