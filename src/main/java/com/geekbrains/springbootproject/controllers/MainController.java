package com.geekbrains.springbootproject.controllers;

import com.geekbrains.springbootproject.entities.Product;
import com.geekbrains.springbootproject.repositories.ProductsRepository;
import com.geekbrains.springbootproject.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String showHomePage(Model model, @RequestParam(required = false) Double min,
                               @RequestParam(required = false) Double max) {

        List<Product> allProducts = null;

        if (min == null && max == null){
            allProducts = productsService.getAllProducts();
        }

        if (min != null && min >= 0 && max == null) {
            allProducts = productsService.getProductsByCoastGreaterThan(min);
        }

        if (min == null && max!=null && max >= 0){
            allProducts = productsService.getProductsByCoastLessThan(max);
        }

        if (min != null && min >= 0 && max!=null && max >= 0){
            allProducts = productsService.getProductsByCoastBetween(min, max);
        }

        model.addAttribute("products", allProducts);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "index";
    }

    @GetMapping("/{pageNum}")
    public String showHomePage(Model model, @PathVariable("pageNum") Integer pageNum,
                               @RequestParam(required = false) Double min,
                               @RequestParam(required = false) Double max) {
        List<Product> allProducts = null;
        if (min == null && max == null){
        allProducts = productsService.getProductsByPage(pageNum);
        } else {
            allProducts = productsService.getProductsByPageFilterByCost(pageNum, min, max);
        }

        model.addAttribute("products", allProducts);
        return "index";
    }

    @GetMapping("/info")
    public String showInfoPage(Model model) {
        return "info";
    }

    @GetMapping("/international")
    public String internationalPage() {
        return "international";
    }

}
