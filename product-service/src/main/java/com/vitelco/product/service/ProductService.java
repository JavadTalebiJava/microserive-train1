package com.vitelco.product.service;

import com.vitelco.product.model.Product;

import java.util.List;

public interface ProductService {

    /**
     * Fetch all products from db
     * @return
     */
    List<Product> findAll();

    /**
     * Save product to DB
     * @param product
     * @return
     */
    Product save(Product product);
}
