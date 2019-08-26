package com.study.workaround.service;

import com.study.workaround.model.State;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StateService {

    private static RestTemplate restTemplate;
    private static final String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";


    public List<State> findStateFromAPI() {
        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        List<State> states = new ArrayList<>();

        JSONArray jsonArray = getJsonArray(url);

        for (int i = 0; i < jsonArray.length(); i++) {
            State state = new State();
            state.setId(jsonArray.getJSONObject(i).getLong("id"));
            state.setName(jsonArray.getJSONObject(i).getString("nome"));
            state.setInitials(jsonArray.getJSONObject(i).getString("sigla"));
            states.add(state);
        }

        return states;
    }

    public static JSONObject getJsonObject(String url) {
        JSONObject jsonObject = new JSONObject();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> mapResponseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
        if (mapResponseEntity.getStatusCode() == HttpStatus.OK) {
            jsonObject = new JSONObject(mapResponseEntity.getBody());
        }
        return jsonObject;
    }

    public static JSONArray getJsonArray(String url) {
        JSONArray jsonArray = new JSONArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map[]> mapResponseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Map[].class);
        if (mapResponseEntity.hasBody() && mapResponseEntity.getStatusCode() == HttpStatus.OK) {
            jsonArray = new JSONArray(mapResponseEntity.getBody());
        }
        return jsonArray;
    }
}
