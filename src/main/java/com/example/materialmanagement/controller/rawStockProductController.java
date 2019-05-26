package com.example.materialmanagement.controller;

import com.example.materialmanagement.exception.ResourceNotFoundException;
import com.example.materialmanagement.model.Supplier;
import com.example.materialmanagement.model.rawStockProduct;
import com.example.materialmanagement.repository.SupplierRepository;
import com.example.materialmanagement.repository.rawStockProductRepository;
import com.example.materialmanagement.repository.rawStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

public class rawStockProductController {
    @Autowired
    rawStockProductRepository rawStockProductRepository;

    @GetMapping("/rawStockProduct")
    public List<rawStockProduct> getAllSupplier(){
        return rawStockProductRepository.findAll();
    }

    @PostMapping("/rawStockProduct")
    public rawStockProduct createRawStockProduct(@Valid @RequestBody rawStockProduct rawStockProduct){
        return rawStockProductRepository.save(rawStockProduct);
    }

    @GetMapping("/rawStockProduct/{id}")
    public rawStockProduct getNoteById(@PathVariable(value = "id") Long rawStockId) {
        return rawStockProductRepository.findById(rawStockId)
                .orElseThrow(() -> new ResourceNotFoundException("rawstock", "id", rawStockId));
    }

    @PutMapping("/rawStockProduct/{id}")
    public rawStockProduct updateRawStock(@PathVariable(value = "id")Long rawStockId,
                               @Valid @RequestBody rawStockProduct rawStockDetails){
        rawStockProduct rawStockProduct = rawStockProductRepository.findById(rawStockId)
                .orElseThrow(()-> new ResourceNotFoundException("rawStockId", "id", rawStockId));

//        supplier.setProductName(supplierDetails.getProductName());
//        supplier.setAddress(supplierDetails.getAddress());
//        supplier.setContact(supplierDetails.getContact());

        rawStockProduct updatedRawStock = rawStockProductRepository.save(rawStockProduct);
        return updatedRawStock;
    }


    @DeleteMapping("/rawStockProduct/{id}")
    public ResponseEntity<?> deleteRawStock(@PathVariable(value = "id") Long rawStockId) {
        rawStockProduct rawStockProduct = rawStockProductRepository.findById(rawStockId)
                .orElseThrow(() -> new ResourceNotFoundException("rawStock", "id", rawStockId));

        rawStockProductRepository.delete(rawStockProduct);

        return ResponseEntity.ok().build();
    }

}