package com.study.workaround.domain.repository;

import com.study.workaround.domain.model.Person;

import java.util.List;

public interface PersonRepositoryQueries {

    List<Person> find(String name, String email);
}
