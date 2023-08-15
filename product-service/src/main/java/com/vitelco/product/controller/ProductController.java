package com.vitelco.product.controller;

import com.vitelco.product.model.Product;
import com.vitelco.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Product product){
        productService.save(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll(){
        return productService.findAll();
    }
}
