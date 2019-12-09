package com.study.workaround.domain.repository;

import com.study.workaround.domain.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonRepositoryQueries {

    List<Person> find(String name, String email);
    <T> List<T> findGeneric(Class<T> classType, Map<String, Object> params);
}
