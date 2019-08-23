package com.study.workaround.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 10, max = 255, message = "O tamanho deve ser entre 10 e 255 caracteres")
    private String description;

    @NotEmpty(message = "Preenchimento obrigatório")
    private Date date;

    @NotEmpty(message = "Preenchimento obrigatório")
    private BigDecimal price;

    @ManyToMany(mappedBy = "parties")
    private List<Person> participants;

    @ManyToOne
    private Address address;


    public Party() {
        this.participants = new ArrayList<>();
        this.price = new BigDecimal("0");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Party)) return false;
        Party party = (Party) o;
        return Objects.equals(id, party.id) &&
                Objects.equals(name, party.name) &&
                Objects.equals(description, party.description) &&
                Objects.equals(date, party.date) &&
                Objects.equals(price, party.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, date, price);
    }
}
