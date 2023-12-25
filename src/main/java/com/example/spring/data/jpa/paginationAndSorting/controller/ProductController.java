package com.example.spring.data.jpa.paginationAndSorting.controller;

import com.example.spring.data.jpa.paginationAndSorting.dto.APIResponse;
import com.example.spring.data.jpa.paginationAndSorting.entity.Product;
import com.example.spring.data.jpa.paginationAndSorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PaginationAndSorting")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/Products")
    public APIResponse<List<Product>> getProducts() {
        List<Product> products = productService.findAllProducts();
        return new APIResponse<>(products.size(), products);
    }

    @GetMapping("/field/{field}")
    public APIResponse<List<Product>> getSortingProduct(@PathVariable String field) {
        List<Product> products = productService.findAllSortingProducts(field);
        return new APIResponse<>(products.size(), products);
    }

    @GetMapping("/Pagination/{OffSet}/{PageSize}")
    public APIResponse<Page<Product>> getPaginationProduct(@PathVariable int OffSet, @PathVariable int PageSize) {
        Page<Product> paginationProducts = productService.findProductWithPagination(OffSet, PageSize);
        return new APIResponse<>(paginationProducts.getSize(), paginationProducts);
    }

    @GetMapping("/PS/{OffSet}/{PageSize}/{field}")
    public APIResponse<Page<Product>> getProductPaginationAndSorting(@PathVariable int OffSet, @PathVariable int PageSize, @PathVariable String field) {
        Page<Product> paginationProducts = productService.findProductPaginationAndSorting(OffSet, PageSize, field);
        return new APIResponse<>(paginationProducts.getSize(), paginationProducts);
    }


}
