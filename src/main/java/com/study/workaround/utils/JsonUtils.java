package com.study.workaround.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static byte[] toJson(Object r) {
        ObjectMapper map = new ObjectMapper();
        try {
            return map.writeValueAsString(r).getBytes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
