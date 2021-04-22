package com.oshovskii.object.relational.patterns.repositories;

import com.oshovskii.object.relational.patterns.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
