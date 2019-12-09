package com.study.workaround.domain.service;

import com.study.workaround.domain.model.Address;
import com.study.workaround.domain.service.feign.CepFeign;
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
