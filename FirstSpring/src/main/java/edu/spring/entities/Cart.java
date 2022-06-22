package edu.spring.entities;

import edu.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class Cart {

    //private int id;
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void put(Product product) {
        products.add(product);
    }

    public void remove(int id) {
        products.removeIf(product -> id == product.getId());
    }

}
