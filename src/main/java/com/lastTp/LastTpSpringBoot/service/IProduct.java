package com.lastTp.LastTpSpringBoot.service;

import com.lastTp.LastTpSpringBoot.entity.Product;

import java.util.List;

public interface IProduct {

    public List<Product> allProducts();

    public Product getProduct(int id);

    public void addProduct(Product product);
}
