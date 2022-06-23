package edu.spring.repository;

import java.util.List;

public interface Repository <T> {

    T getProduct(int id);

    List<T> getAllProducts();
}
