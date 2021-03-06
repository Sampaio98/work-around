package com.study.workaround.domain.repository;

import com.study.workaround.domain.model.Person;
import com.study.workaround.domain.repository.customized.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryQueries, GenericRepository<Person> {

}
