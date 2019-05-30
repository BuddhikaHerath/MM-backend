package com.example.materialmanagement.controller;


import com.example.materialmanagement.exception.ResourceNotFoundException;
import com.example.materialmanagement.model.Supplier;
import com.example.materialmanagement.model.product;
import com.example.materialmanagement.repository.SupplierRepository;
import com.example.materialmanagement.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class productController {

    @Autowired
    productRepository productRepository;

    @GetMapping("/product")
    public List<product> getAllSupplier() {
        return productRepository.findAll();
    }

    @PostMapping("/product")
    public product createProduct(@Valid @RequestBody product product) {
        return productRepository.save(product);
    }

    @GetMapping("/product/{id}")
    public product getNoteById(@PathVariable(value = "id") Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "id", productId));
    }

    @PutMapping("/product/{id}")
    public product updateProduct(@PathVariable(value = "id") Long productId,
                                 @Valid @RequestBody Supplier productDetails) {
        product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "id", productId));

//        supplier.setProductName(supplierDetails.getProductName());
//        supplier.setAddress(supplierDetails.getAddress());
//        supplier.setContact(supplierDetails.getContact());

        product updateProduct = productRepository.save(product);
        return updateProduct;
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
        product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "id", productId));

        productRepository.delete(product);

        return ResponseEntity.ok().build();
    }

}