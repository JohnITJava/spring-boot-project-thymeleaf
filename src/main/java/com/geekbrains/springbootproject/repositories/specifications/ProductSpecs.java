package com.geekbrains.springbootproject.repositories.specifications;

import com.geekbrains.springbootproject.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecs {
    public static Specification<Product> titleContains(String word){
        return (Specification<Product>) (root, criteriaQuery, criteriaBulder) ->
                criteriaBulder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Product> priceGreaterThanOrEq(double value){
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), value);
    }

    public static Specification<Product> priceLessThanOrEq(double value){
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("cost"), value);
    }
}
