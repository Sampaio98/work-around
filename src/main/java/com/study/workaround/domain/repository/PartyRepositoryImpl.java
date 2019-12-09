package com.study.workaround.domain.repository;

import com.study.workaround.domain.exception.ObjectNotFoundException;
import com.study.workaround.domain.model.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PartyRepositoryImpl {

    private static final String NOT_FOUND_MSG = "Party not found.";

    @Autowired
    private PartyRepository jpa;

    public Party save(Party party) {
        return jpa.save(party);
    }

    public Party findById(Long id) {
        return jpa.findById(id).orElseThrow(() -> new ObjectNotFoundException(NOT_FOUND_MSG));
    }

    public Party findByIdNative(Long id) {
        return jpa.findPartyLoka(id).orElseThrow(() -> new ObjectNotFoundException(NOT_FOUND_MSG));
    }

    public Party findByName(String name) {
        return jpa.findByTitle(name).orElseThrow(() -> new ObjectNotFoundException(NOT_FOUND_MSG));
    }
}
