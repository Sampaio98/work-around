package com.study.workaround.service;

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
}
