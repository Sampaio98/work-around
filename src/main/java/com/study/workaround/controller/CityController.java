package com.study.workaround.controller;

import com.study.workaround.dto.CityDTO;
import com.study.workaround.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping(value = "/state/{id}")
    public ResponseEntity<List<CityDTO>> findCitiesByStateId(@PathVariable("id") Long id) {
        List<CityDTO> cities = service.findCitiesByStateId(id);
        return ResponseEntity.ok().body(cities);
    }
}