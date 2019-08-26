package com.study.workaround.service;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateSingleton {

    private static RestTemplate restTemplate;

    private RestTemplateSingleton() { }

    public static synchronized RestTemplate getRestTemplate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        }
        return restTemplate;
    }
}
