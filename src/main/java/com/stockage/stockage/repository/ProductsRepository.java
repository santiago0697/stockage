package com.stockage.stockage.repository;

import com.stockage.stockage.model.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<products, Integer> {
}
