package com.study.workaround.domain.repository;

import com.study.workaround.domain.model.Person;
import com.study.workaround.utils.ClassHelper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class PersonRepositoryImpl implements PersonRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Person> find(String name, String email) {
        String tableName = ClassHelper.getTableName(Person.class);

        StringBuilder jpql = new StringBuilder();
        jpql.append("from ").append(tableName).append(" where 0 = 0 ");

        HashMap<String, Object> params = new HashMap<>();

        if (StringUtils.hasLength(name)) {
            jpql.append("and name like :name ");
            params.put("name", "%" + name + "%");
        }

        if (StringUtils.hasLength(email)) {
            jpql.append("and email = :email ");
            params.put("email", email);
        }

        TypedQuery<Person> query = manager.createQuery(jpql.toString(), Person.class);
        params.forEach(query::setParameter);
        return query.getResultList();
    }

    @Override
    public <T> List<T> findGeneric(Class<T> classType, Map<String, Object> params) {
        String tableName = ClassHelper.getTableName(classType);
        StringBuilder jpql = new StringBuilder();
        jpql.append("from ").append(tableName).append(" where 0 = 0");

        params.keySet().forEach(key -> jpql.append(" and ").append(key).append(" = :").append(key));
        TypedQuery<T> query = manager.createQuery(jpql.toString(), classType);
        params.forEach(query::setParameter);
        return query.getResultList();
    }

}
