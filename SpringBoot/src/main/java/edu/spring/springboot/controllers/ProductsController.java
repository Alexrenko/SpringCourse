package edu.spring.springboot.controllers;

import edu.spring.springboot.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @Autowired
    private ProductDao dao;

    @GetMapping("/products.html")
    public String getProducts(Model model) {
        model.addAttribute("productList", dao.findAll());
        return "products";
    }
}
