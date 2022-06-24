package edu.spring.springboot.controllers;

import edu.spring.springboot.entities.Product;
import edu.spring.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/addproduct.html")
    public String getForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addproduct";
    }

    @PostMapping("/addproduct.html")
    public String addProduct(Product product) {
        product.setId(repository.getIdCount());
        repository.add(product);
        return "redirect:products.html";
    }

}
