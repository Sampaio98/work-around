package com.study.workaround.controller;

import com.study.workaround.model.State;
import com.study.workaround.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.SortedSet;

@RestController
@RequestMapping(value = "/states")
public class StateController {

    @Autowired
    private StateService service;

    @GetMapping
    public ResponseEntity<List<State>> findStateFromAPI() {
        List<State> states = service.findStateFromAPI();
        return ResponseEntity.ok().body(states);
    }

    @GetMapping(value = "/feign")
    public SortedSet<State> findAllFromAPI() {
        return service.findAllFromAPI();
    }
}
