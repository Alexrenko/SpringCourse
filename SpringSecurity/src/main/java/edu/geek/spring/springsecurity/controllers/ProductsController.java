package edu.geek.spring.springsecurity.controllers;

import edu.geek.spring.springsecurity.entities.Product;
import edu.geek.spring.springsecurity.services.PageService;
import edu.geek.spring.springsecurity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PageService pageService;

    //добавление нового товара
    @PostMapping("/create")
    public String createProduct(Product product) {
        productService.saveOrUpdate(product);
        return pageService.getProductsPageStr(true);
    }

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

    //Страница изменения товара
    @GetMapping("/products/change/{id}")
    public String getChangePage(Model model,
                                @PathVariable(value = "id") long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "change";
    }

    //Изменение товара
    @PostMapping("/products/change")
    public String changeProduct(Product product) {
        productService.saveOrUpdate(product);

        int curPageNo = pageService.getCurrentPageNo();
        String param = "?amount=" + pageService.getAmountPerPage();
        return "redirect:/products/page/" + curPageNo + param;
    }

    //удаление товара по id
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(Model model, @PathVariable(value = "id") long id) {
        productService.delete(id);
        return pageService.getProductsPageStr(false);
    }
}
