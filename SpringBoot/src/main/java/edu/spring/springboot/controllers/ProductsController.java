package edu.spring.springboot.controllers;

import edu.spring.springboot.dao.ProductDao;
import edu.spring.springboot.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductsController {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private Service service;

    @GetMapping("/products.html")
    public String getProducts(Model model) {
        model.addAttribute("productList", productDao.findAll());
        return "products";
    }

    @GetMapping("/customer_list/{id}")
    public String getCustomers(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("customer_list", service.getCustomersByProductId(id));
        return "customer_list";
    }
}
