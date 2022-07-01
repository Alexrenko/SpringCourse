package edu.spring.springboot.controllers;

import edu.spring.springboot.dao.CustomerDao;
import edu.spring.springboot.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomersController {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Service service;

    @GetMapping("/customers.html")
    public String getCustomers(Model model) {
        model.addAttribute("customerList", customerDao.findAll());
        return "customers";
    }

    @GetMapping("/product_list/{id}")
    public String getProducts(Model model, @PathVariable (value = "id") long id) {
        model.addAttribute("name", customerDao.findById(id).getName());
        model.addAttribute("product_list", service.getProductsByCustomerId(id));
        return "product_list";
    }

}
