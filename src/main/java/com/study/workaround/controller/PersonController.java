package com.study.workaround.controller;

import com.study.workaround.domain.model.Person;
import com.study.workaround.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public List<Person> find(String name, String email) {
        HashMap<String, Object> params = new HashMap<>();
        if(StringUtils.hasLength(name)) {
            params.put("name", name);
        }
        if(StringUtils.hasLength(email)) {
            params.put("email", email);
        }
        return repository.findGeneric(Person.class, params);
    }
}
