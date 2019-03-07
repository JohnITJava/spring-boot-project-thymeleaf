package com.geekbrains.springbootproject.repositories;

import com.geekbrains.springbootproject.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("SELECT p FROM Product p WHERE id = 1")
    Product findWithIdOne();

    List<Product> findProductByCostGreaterThan(double min);

    List<Product> findProductByCostLessThan(double max);

    List<Product> findProductByCostBetween(double min, double max);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findProductByCostBetween(Pageable pageable, double min, double max);

    Product findOneByTitle(String title);
}
