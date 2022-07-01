package edu.spring.springboot.dao;

import java.util.List;

public interface Dao<T> {

    void create(T t);

    T findById(Long id);

    List<T> findAll();

    void saveOrUpdate(T t);

    void deleteById(Long id);
}
