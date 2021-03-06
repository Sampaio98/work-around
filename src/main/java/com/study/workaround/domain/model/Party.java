package com.study.workaround.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Party {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String title;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 10, max = 255, message = "O tamanho deve ser entre 10 e 255 caracteres")
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime date;

    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "party")
    private Address address;

    @OneToMany(mappedBy = "party")
    @JsonIgnoreProperties(value = "party")
    private Set<PartyDetail> partyDetail;


    public Party() {
        this.partyDetail = new HashSet<>();
        this.price = new BigDecimal("0");
    }
}
