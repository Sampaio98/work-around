package com.study.workaround.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "CepFeign")
public interface CepFeign {

    @GetMapping("{cep}/json")
    Object findByCep(@PathVariable("cep") String cep);

}
