package com.study.workaround.service;

import com.study.workaround.model.State;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.study.workaround.service.JsonService.getJsonArray;

@Service
@Transactional
public class StateService {

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
}
