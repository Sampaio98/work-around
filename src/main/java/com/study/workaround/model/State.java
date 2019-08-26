package com.study.workaround.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class State {

    @Column(name = "state_id")
    private Long id;

    @Column(name = "state_name")
    private String name;

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
}
