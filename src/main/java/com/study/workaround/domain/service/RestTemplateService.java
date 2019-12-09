package com.study.workaround.domain.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.study.workaround.utils.RestTemplateSingleton.getRestTemplate;

@Service
public class RestTemplateService {

    public static JSONObject getJsonObject(String url) {
        JSONObject jsonObject = new JSONObject();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> mapResponseEntity = getRestTemplate().exchange(url, HttpMethod.GET, entity, Map.class);
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
        ResponseEntity<Map[]> mapResponseEntity = getRestTemplate().exchange(url, HttpMethod.GET, entity, Map[].class);
        if (mapResponseEntity.hasBody() && mapResponseEntity.getStatusCode() == HttpStatus.OK) {
            jsonArray = new JSONArray();
        }
        return jsonArray;
    }
}
