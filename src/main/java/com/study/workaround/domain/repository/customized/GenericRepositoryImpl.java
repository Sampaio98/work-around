package com.study.workaround.domain.repository.customized;

import com.study.workaround.utils.ClassHelper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class GenericRepositoryImpl<T> implements GenericRepository<T>{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<T> findGeneric(Class<T> entity, Map<String, Object> params) {
        String jpql = buildQuery(entity, params);
        TypedQuery<T> query = manager.createQuery(jpql, entity);
        params.forEach(query::setParameter);
        return query.getResultList();
    }

    @Override
    public List<?> findGeneric(Class<T> entity, Map<String, Object> params, Class<?> respClass) {
        String jpql = buildQuery(entity, params);
        TypedQuery<?> query = manager.createQuery(jpql, entity);
        params.forEach(query::setParameter);
        return query.getResultList();
    }

    private String buildQuery(Class<T> entity, Map<String, Object> params) {
        String tableName = ClassHelper.getTableName(entity);
        StringBuilder jpql = new StringBuilder();
        jpql.append("from ").append(tableName).append(" where 0 = 0");

        params.keySet().forEach(key -> jpql.append(" and ").append(key).append(" = :").append(key));
        return jpql.toString();
    }

}
