package com.study.workaround.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Person {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2, max = 120, message = "O tamanho deve ser entre 2 e 120 caracteres")
    private String name;

    @Column(unique = true)
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @Column(unique = true)
    @NotEmpty(message = "Preenchimento obrigatório")
    @ElementCollection
    @CollectionTable(name = "PERSON_CELLPHONE")
    private Set<String> cellphone;

    @OneToMany(mappedBy = "person")
    @JsonIgnoreProperties(value = "person")
    private Set<PartyDetail> partyDetails;

    public Person() {
        this.partyDetails = new HashSet<>();
        this.cellphone = new HashSet<>();
    }
}


