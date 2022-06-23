package edu.spring.controllers;

import edu.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("productList", repository.getAllProducts());
        return "products";
    }
}
