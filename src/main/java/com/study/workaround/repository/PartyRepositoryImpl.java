package com.study.workaround.repository;

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
}
