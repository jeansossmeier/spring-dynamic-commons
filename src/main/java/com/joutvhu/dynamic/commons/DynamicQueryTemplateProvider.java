package com.joutvhu.dynamic.commons;

public interface DynamicQueryTemplateProvider<T> {
    DynamicQueryTemplate<T> createTemplate(String name, String query);
    DynamicQueryTemplate<T> findTemplate(String name);
}
