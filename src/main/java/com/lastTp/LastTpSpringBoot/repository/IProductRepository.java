package com.lastTp.LastTpSpringBoot.repository;

import com.lastTp.LastTpSpringBoot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
