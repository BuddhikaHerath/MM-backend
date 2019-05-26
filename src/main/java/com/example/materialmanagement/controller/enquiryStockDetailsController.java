package com.example.materialmanagement.controller;

import com.example.materialmanagement.exception.ResourceNotFoundException;
import com.example.materialmanagement.model.Supplier;
import com.example.materialmanagement.model.enquiryStockDetails;
import com.example.materialmanagement.model.product;
import com.example.materialmanagement.repository.enquiryStockDetailsRepository;
import com.example.materialmanagement.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class enquiryStockDetailsController {

    @Autowired
    enquiryStockDetailsRepository enquiryStockDetailsRepository;

    @GetMapping("/enquiryStockDetail")
    public List<enquiryStockDetails> getAllSupplier(){
        return enquiryStockDetailsRepository.findAll();
    }

    @PostMapping("/enquiryStockDetail")
    public enquiryStockDetails createenquiryStockDetails(@Valid @RequestBody enquiryStockDetails enquiryStockDetails){
        return enquiryStockDetailsRepository.save(enquiryStockDetails);
    }

    @GetMapping("/enquiryStockDetail/{id}")
    public enquiryStockDetails getNoteById(@PathVariable(value = "id") Long enquiryStockId) {
        return enquiryStockDetailsRepository.findById(enquiryStockId)
                .orElseThrow(() -> new ResourceNotFoundException("enquiryStockDetail", "id", enquiryStockId));
    }

    @PutMapping("/enquiryStockDetail/{id}")
    public enquiryStockDetails updateenquiryStockDetails(@PathVariable(value = "id")Long enquiryStockId,
                                 @Valid @RequestBody enquiryStockDetails enquiryStockDetails){
        enquiryStockDetails enquiryStockDetails1 = enquiryStockDetailsRepository.findById(enquiryStockId)
                .orElseThrow(()-> new ResourceNotFoundException("enquiry", "id", enquiryStockId));

//        supplier.setProductName(supplierDetails.getProductName());
//        supplier.setAddress(supplierDetails.getAddress());
//        supplier.setContact(supplierDetails.getContact());

        enquiryStockDetails updateenquiryStock = enquiryStockDetailsRepository.save(enquiryStockDetails);
        return updateenquiryStock;
    }


    @DeleteMapping("/enquiryStockDetail/{id}")
    public ResponseEntity<?> deleteEnquiryDetail(@PathVariable(value = "id") Long enquiryStockId) {
        enquiryStockDetails enquiryStockDetails = enquiryStockDetailsRepository.findById(enquiryStockId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "id", enquiryStockId));

        enquiryStockDetailsRepository.delete(enquiryStockDetails);

        return ResponseEntity.ok().build();
    }



}
