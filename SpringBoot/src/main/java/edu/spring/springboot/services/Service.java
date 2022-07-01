package edu.spring.springboot.services;

import edu.spring.springboot.dao.CustomerDao;
import edu.spring.springboot.dao.ProductDao;
import edu.spring.springboot.entities.Customer;
import edu.spring.springboot.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ProductDao productDao;

    public List<Product> getProductsByCustomerId(long id) {
        Customer customer = customerDao.findById(id);
        return customer.getProducts();
    }

    public List<Customer> getCustomersByProductId(long id) {
        Product product = productDao.findById(id);
        return product.getCustomers();
    }
}
