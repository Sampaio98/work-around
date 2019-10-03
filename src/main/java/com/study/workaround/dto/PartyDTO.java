package com.study.workaround.dto;

import com.study.workaround.model.Party;
import lombok.Data;

@Data
public class PartyDTO {

    private Long id;
    private String title;

    public PartyDTO(Party party) {
        super();
        this.id = party.getId();
        this.title = party.getTitle();
    }
}
