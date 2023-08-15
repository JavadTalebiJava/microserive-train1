package com.vitelco.product.service;

import com.vitelco.product.model.Product;
import com.vitelco.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;


    /**
     * Fetch all products from db
     *
     * @return
     */
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Save product to DB
     *
     * @param product
     * @return
     */
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
