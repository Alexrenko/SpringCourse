package edu.spring.springboot.controllers;

import edu.spring.springboot.entities.Product;
import edu.spring.springboot.services.PageService;
import edu.spring.springboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PageService pageService;

    //получение всех товаров
    @GetMapping("/products/page/{pageNo}")
    public String getProducts(@RequestParam(defaultValue = "10") int amount,
                              @PathVariable(value = "pageNo") int pageNo,
                              Model model) {
        pageService.setAmountPerPage(amount);
        pageService.changePage(pageNo);

        model.addAttribute("productList", pageService.getPage());
        model.addAttribute("pageList", pageService.getPageList());
        model.addAttribute("am", amount);

        model.addAttribute("newProduct", new Product());
        return "products";
    }

    //добавление нового товара
    @PostMapping("/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);

        int curPageNo = pageService.getCurrentPageNo();
        String param = "?amount=" + pageService.getAmountPerPage();
        if (pageService.isJumpNextPage())
            return "redirect:products/page/" + (curPageNo + 1) + param;
        else
            return "redirect:products/page/" + curPageNo + param;
    }

    //удаление товара по id
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(Model model, @PathVariable(value = "id") long id) {
        productService.deleteProductById(id);

        int curPageNo = pageService.getCurrentPageNo();
        String param = "?amount=" + pageService.getAmountPerPage();;
        if (pageService.isJumpPrevPage())
            return "redirect:/products/page/" + (curPageNo - 1) + param;
        else
            return "redirect:/products/page/" + curPageNo + param;
    }

}
