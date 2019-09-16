package com.study.workaround.service;

import com.study.workaround.model.Address;
import com.study.workaround.service.feign.CepFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private CepFeign feign;

    public Address findByCepFromAPI(String cep){
        Object obj = feign.findByCep(cep);
        return null;
    }
}
