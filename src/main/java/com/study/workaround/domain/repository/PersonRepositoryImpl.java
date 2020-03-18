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
}
