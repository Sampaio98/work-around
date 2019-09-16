package com.study.workaround.service.feign;

import com.study.workaround.model.State;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.SortedSet;

@FeignClient(url = "http://servicodados.ibge.gov.br/api/v1/localidades/estados", name = "LocaleFeign")
public interface LocalesFeign {

    @GetMapping("/")
    SortedSet<State> findAll();
}
