package edu.spring.springboot.dao;

import java.util.List;

public interface dao<T> {

    T findById(Long id);

    List<T> findAll();

    void deleteById(Long id);

    void saveOrUpdate(T t);
}
