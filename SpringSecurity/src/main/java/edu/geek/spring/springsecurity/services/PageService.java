package edu.geek.spring.springsecurity.services;

import edu.geek.spring.springsecurity.entities.Product;
import edu.geek.spring.springsecurity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {

    @Autowired
    private ProductRepository repository;

    private int currentPageNo = 1;
    private int amountPerPage = 10;
    Page<Product> page;


    public void changePage(int pageNo) {
        page = repository.findAll(PageRequest.of(pageNo - 1, amountPerPage));
        currentPageNo = pageNo;
    }

    public List<Integer> getPageList() {
        List<Integer> pageList = new ArrayList<>();
        for (int i = 0; i < page.getTotalPages(); i++) {
            pageList.add(i + 1);
        }
        return pageList;
    }

    public boolean isJumpPrevPage() {
        return page.getTotalElements() - (currentPageNo - 1) * amountPerPage == 1
                && currentPageNo != 1;
    }

    public boolean isJumpNextPage() {
        return page.getTotalElements() - currentPageNo * amountPerPage == 0;
    }

    public String getProductsPageStr(boolean isJumpNext) {
        String param = "?amount=" + amountPerPage;
        if (isJumpNext) {
            if (isJumpNextPage())
                return "redirect:/products/page/" + (currentPageNo + 1) + param;
            else
                return "redirect:/products/page/" + currentPageNo + param;
        } else {
            if (isJumpPrevPage())
                return "redirect:/products/page/" + (currentPageNo - 1) + param;
            else
                return "redirect:/products/page/" + currentPageNo + param;
        }
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getAmountPerPage() {
        return amountPerPage;
    }

    public void setAmountPerPage(int amountPerPage) {
        this.amountPerPage = amountPerPage;
    }

    public Page<Product> getPage() {
        return page;
    }

    public void setPage(Page<Product> page) {
        this.page = page;
    }
}
