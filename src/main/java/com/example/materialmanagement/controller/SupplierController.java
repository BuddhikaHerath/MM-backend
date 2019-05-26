package com.example.materialmanagement.controller;

import com.example.materialmanagement.exception.ResourceNotFoundException;
import com.example.materialmanagement.model.Supplier;
import com.example.materialmanagement.model.User;
import com.example.materialmanagement.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {


    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping("/supplier")
    public List<Supplier> getAllSupplier(){
        return supplierRepository.findAll();
    }

    @PostMapping("/supplier")
    public Supplier createUser(@Valid @RequestBody Supplier supplier){
        return supplierRepository.save(supplier);
    }

    @GetMapping("/supplier/{id}")
    public Supplier getNoteById(@PathVariable(value = "id") Long supplierId) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("supplier", "id", supplierId));
    }

    @PutMapping("/supplier/{id}")
    public Supplier updateUser(@PathVariable(value = "id")Long supplierId,
                           @Valid @RequestBody Supplier supplierDetails){
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(()-> new ResourceNotFoundException("supplier", "id", supplierId));

//        supplier.setProductName(supplierDetails.getProductName());
//        supplier.setAddress(supplierDetails.getAddress());
//        supplier.setContact(supplierDetails.getContact());

        Supplier updatedsupplier = supplierRepository.save(supplier);
        return updatedsupplier;
    }


    @DeleteMapping("/supplier/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable(value = "id") Long supplierID) {
        Supplier supplier = supplierRepository.findById(supplierID)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", supplierID));

        supplierRepository.delete(supplier);

        return ResponseEntity.ok().build();
    }


}
