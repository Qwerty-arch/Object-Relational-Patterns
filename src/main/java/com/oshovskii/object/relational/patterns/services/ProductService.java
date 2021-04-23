package com.oshovskii.object.relational.patterns.services;

import com.oshovskii.object.relational.patterns.entity.Product;
import com.oshovskii.object.relational.patterns.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final Map<Long, Product> identityProductList;

    public List<Product> findAll() {
        for (Product product : productRepository.findAll()) {
            identityProductList.put(product.getId(), product);
        }
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        if (identityProductList.containsKey(id)) {
            return Optional.of(identityProductList.get(id));
        }
        Optional<Product> optionalProduct = Optional.of(productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product don't exist")));
        Product product = optionalProduct.get();
        identityProductList.put(product.getId(), product);

        return optionalProduct;
    }
}
