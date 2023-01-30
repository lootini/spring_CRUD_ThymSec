package com.lastTp.LastTpSpringBoot.service;

import com.lastTp.LastTpSpringBoot.entity.Product;
import com.lastTp.LastTpSpringBoot.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProduct{

    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> allProducts() {
        return iProductRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return iProductRepository.getById(id);
    }

    @Override
    public void addProduct(Product product) {
        iProductRepository.save(product);
    }
}
