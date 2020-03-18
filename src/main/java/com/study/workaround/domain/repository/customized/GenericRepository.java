package com.study.workaround.domain.repository.customized;

import java.util.List;
import java.util.Map;

public interface GenericRepository<T> {

    List<T> findGeneric(Class<T> entity, Map<String, Object> params);
    List<?> findGeneric(Class<T> entity, Map<String, Object> params, Class<?> respClass);
//    List<T> findGeneric(Class<T> entity, Map<String, Object> params, Class<?> respClass);
}
