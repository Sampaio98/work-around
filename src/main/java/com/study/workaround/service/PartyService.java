package com.study.workaround.service;

import com.study.workaround.config.DBConfig;
import com.study.workaround.dto.PartyDTO;
import com.study.workaround.model.Party;
import com.study.workaround.repository.PartyRepositoryImpl;
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
        return repository.findByIdNative(id);
    }

    public Party findByName(String name) {
        return repository.findByName(name);
    }
}
