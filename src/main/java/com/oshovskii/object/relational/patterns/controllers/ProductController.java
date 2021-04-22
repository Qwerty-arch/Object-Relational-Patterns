package com.oshovskii.object.relational.patterns.controllers;

import com.oshovskii.object.relational.patterns.entity.Product;
import com.oshovskii.object.relational.patterns.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProducts(){
        return productService.findAll();

    }

    @DeleteMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id).get();
    }
}
