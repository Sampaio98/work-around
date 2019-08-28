package com.study.workaround.repository;

import com.study.workaround.config.DBConfig;
import com.study.workaround.dto.PartyDTO;
import com.study.workaround.exception.ObjectNotFoundException;
import com.study.workaround.model.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartyRepositoryImpl {

    @Autowired
    private PartyRepository jpa;

    public Party save(Party party) {
        return jpa.save(party);
    }

    public Party findById(Long id) {
        return jpa.findById(id).orElseThrow(() -> new ObjectNotFoundException("Party not found."));
    }

    public PartyDTO findByIdNative(Long id) {
        Party party = jpa.findPartyLoka(id).orElseThrow(() -> new ObjectNotFoundException("Party not found."));
        return new PartyDTO(party);
    }

    public Party findByName(String name) {
        return jpa.findPartyByName(name).orElseThrow(() -> new ObjectNotFoundException("Party not found."));
    }
}
