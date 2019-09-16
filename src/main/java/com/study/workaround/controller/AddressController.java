package com.study.workaround.controller;

import com.study.workaround.model.Address;
import com.study.workaround.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping(value = "/cep/{cep}")
    public ResponseEntity<Address> findByCepFromAPI(@PathVariable("cep") String cep) {
        Address address = service.findByCepFromAPI(cep);
        return ResponseEntity.ok().body(address);
    }
}
