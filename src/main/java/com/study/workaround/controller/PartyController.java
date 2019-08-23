package com.study.workaround.controller;

import com.study.workaround.model.Party;
import com.study.workaround.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/parties")
public class PartyController {

    @Autowired
    private PartyService service;

    @PostMapping
    public ResponseEntity<Party> insert(@RequestBody @Valid Party partyFromRequest){
        Party party = service.insert(partyFromRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(party.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
