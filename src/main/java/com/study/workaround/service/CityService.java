package com.study.workaround.service;

import com.study.workaround.dto.CityDTO;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.study.workaround.service.JsonService.getJsonArray;

@Service
public class CityService {

    public List<CityDTO> findCitiesByStateId(Long id) {
        final String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + id.toString() + "/municipios";

        JSONArray jsonArray = getJsonArray(url);
        List<CityDTO> cities = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            CityDTO cityDTO = new CityDTO();
            cityDTO.setId(jsonArray.getJSONObject(i).getLong("id"));
            cityDTO.setName(jsonArray.getJSONObject(i).getString("nome"));
            cities.add(cityDTO);
        }

        return cities;
    }
}
