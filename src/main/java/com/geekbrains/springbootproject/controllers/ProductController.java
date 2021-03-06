package com.geekbrains.springbootproject.controllers;

import com.geekbrains.springbootproject.entities.Product;
import com.geekbrains.springbootproject.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/product/edit/{id}")
    public String addProductPage(Model model, @PathVariable("id") Long id) {
        Product product = productsService.findById(id);
        if (product == null) {
            product = new Product();
        }
        model.addAttribute("product", product);
        return "edit-product";
    }

    // Binding Result после @ValidModel !!!
    //Продукт приходит с фронта, Valid показывает, что будет валидация
    //Результаты прилетают в bindingResult
    @PostMapping("/product/edit")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "edit-product";
        }
        Product existing = productsService.findByTitle(product.getTitle());
        if (existing != null && (product.getId() == null || !product.getId().equals(existing.getId()))) {
            // product.setTitle(null);
            model.addAttribute("product", product);
            model.addAttribute("productCreationError", "Product title already exists");
            return "edit-product";
        }
        productsService.saveOrUpdate(product);
        return "redirect:/";
    }

}
