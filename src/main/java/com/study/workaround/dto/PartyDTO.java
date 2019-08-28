package com.study.workaround.dto;

import com.study.workaround.model.Party;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartyDTO {

    private Long id;
    private String title;

    public PartyDTO(Party party) {
        this.id = party.getId();
        this.title = party.getTitle();
    }
}
