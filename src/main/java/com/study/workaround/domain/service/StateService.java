package com.study.workaround.domain.service;

import com.study.workaround.domain.model.State;
import com.study.workaround.domain.service.feign.LocalesFeign;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.study.workaround.domain.service.RestTemplateService.getJsonArray;

@Service
@Transactional
public class StateService {

    @Autowired
    private LocalesFeign feign;

    private static final String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";


    public List<State> findStateFromAPI() {

        JSONArray jsonArray = getJsonArray(url);
        List<State> states = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            State state = new State();
            state.setId(jsonArray.getJSONObject(i).getLong("id"));
            state.setName(jsonArray.getJSONObject(i).getString("nome"));
            state.setInitials(jsonArray.getJSONObject(i).getString("sigla"));
            states.add(state);
        }

        return states;
    }

    public SortedSet<State> findAllFromAPI() {
        return feign.findAll();
    }
}
