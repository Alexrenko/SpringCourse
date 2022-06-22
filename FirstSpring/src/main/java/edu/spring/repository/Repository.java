package edu.spring.repository;

import java.util.List;

public interface Repository<T> {

    List<T> getAll();

    T getById(int id);
}
