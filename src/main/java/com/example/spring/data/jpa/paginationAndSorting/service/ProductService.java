package com.example.spring.data.jpa.paginationAndSorting.service;

import com.example.spring.data.jpa.paginationAndSorting.entity.Product;
import com.example.spring.data.jpa.paginationAndSorting.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @PostConstruct
    public void initDB() {
        List<Product> products;
        products = IntStream.rangeClosed(1, 200)
                .mapToObj(i -> new Product(i, "product" + i, new Random().nextInt(100), new Random().nextInt(500000)))
                .collect(Collectors.toList());
        productRepository.saveAll(products);

    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findAllSortingProducts(String field) {
        return productRepository.findAll(Sort.by(field));
    }

    public Page<Product> findProductWithPagination(int OffSet, int PageSize) {
        return productRepository.findAll(PageRequest.of(OffSet, PageSize));

    }

    public Page<Product> findProductPaginationAndSorting(int OffSet, int PageSize, String field) {
        return productRepository.findAll(PageRequest.of(OffSet, PageSize).withSort(Sort.by(field)));

    }


}
