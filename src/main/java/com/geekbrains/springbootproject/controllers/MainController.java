package com.geekbrains.springbootproject.controllers;

import com.geekbrains.springbootproject.entities.Product;
import com.geekbrains.springbootproject.repositories.ProductsRepository;
import com.geekbrains.springbootproject.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        if (min == null && max == null){
            List<Product> allProducts = productsService.getAllProducts();
            model.addAttribute("products", allProducts);
            return "index";
        }

        if (min != null && min >= 0 && max == null) {
            List<Product> allProducts = productsService.getProductsByCoastGreaterThan(min);
            model.addAttribute("products", allProducts);
            return "index";
        }

        if (min == null && max >= 0){
            List<Product> allProducts = productsService.getProductsByCoastLessThan(max);
            model.addAttribute("products", allProducts);
            return "index";
        }

        if (min != null && min >= 0 && max >= 0){
            List<Product> allProducts = productsService.getProductsByCoastBetween(min, max);
            model.addAttribute("products", allProducts);
            return "index";
        }

        return "index";
    }

    @GetMapping("/{pageNum}")
    public String showHomePage(Model model, @PathVariable("pageNum") Integer pageNum) {
        List<Product> allProducts = productsService.getProductsByPage(pageNum);
        model.addAttribute("products", allProducts);
        return "index";
    }

    @GetMapping("/info")
    public String showInfoPage(Model model) {
        return "info";
    }

    @GetMapping("/product/add")
    public String addProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping("/product/add")
    public String addProduct(Model model, @ModelAttribute("product") Product product) {
        productsService.saveOrUpdate(product);
        return "redirect:/";
    }

}
