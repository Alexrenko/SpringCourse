package edu.spring.springboot.controllers;

import edu.spring.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/products.html")
    public String getProducts(Model model) {
        model.addAttribute("productList", repository.getAllProducts());
        return "products";
    }
}
