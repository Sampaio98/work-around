package com.study.workaround.utils;

import javax.persistence.Table;

public class ClassHelper {

    public static String getTableName(Class<?> classType) {
        Table table = classType.getAnnotation(Table.class);
        return table != null ? table.name() : classType.getSimpleName();
    }
}
