package com.study.workaround.domain.service;

import com.study.workaround.domain.dto.PartyDTO;
import com.study.workaround.domain.model.Party;
import com.study.workaround.domain.repository.PartyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartyService {

    @Autowired
    private PartyRepositoryImpl repository;


    public Party insert(Party party){
        return repository.save(party);
    }

    public Party findById(Long id) {
        return repository.findById(id);
    }

    public PartyDTO findByIdNative(Long id) {
        Party party = repository.findByIdNative(id);
        return new PartyDTO(party);
    }

    public Party findByName(String name) {
        return repository.findByName(name);
    }
}
