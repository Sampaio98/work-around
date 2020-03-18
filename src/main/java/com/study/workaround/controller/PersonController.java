package com.study.workaround.controller;

import com.study.workaround.domain.model.Person;
import com.study.workaround.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/people")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public List<Person> find(@RequestBody Map<String, Object> parameters) {
        return repository.findGeneric(Person.class, parameters);
    }
}
