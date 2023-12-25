package com.example.spring.data.jpa.paginationAndSorting.repository;

import com.example.spring.data.jpa.paginationAndSorting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
