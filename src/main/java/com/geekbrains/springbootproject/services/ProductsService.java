package com.geekbrains.springbootproject.services;

import com.geekbrains.springbootproject.entities.Product;
import com.geekbrains.springbootproject.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getAllProducts() {
        return (List<Product>)productsRepository.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

    public List<Product> getProductsByCoastGreaterThan(double min){
        return productsRepository.findProductByCostGreaterThan(min);
    }

    public List<Product> getProductsByCoastLessThan(double max){
        return productsRepository.findProductByCostLessThan(max);
    }

    public List<Product> getProductsByCoastBetween(double min, double max){
        return productsRepository.findProductByCostBetween(min, max);
    }

    public List<Product> getProductsByPage(int page){
        return productsRepository.findAll(PageRequest.of(page - 1, 5)).getContent();
    }
}
