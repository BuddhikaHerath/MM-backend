package com.example.materialmanagement.controller;

import com.example.materialmanagement.exception.ResourceNotFoundException;
import com.example.materialmanagement.model.Supplier;
import com.example.materialmanagement.model.address;
import com.example.materialmanagement.model.product;
import com.example.materialmanagement.repository.addressRepository;
import com.example.materialmanagement.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class addressController {

    @Autowired
    addressRepository addressRepository;

    @GetMapping("/address")
    public List<address> getAllSupplier(){
        return addressRepository.findAll();
    }

    @PostMapping("/address")
    public address createProduct(@Valid @RequestBody address address){
        return addressRepository.save(address);
    }

    @GetMapping("/address/{id}")
    public address getNoteById(@PathVariable(value = "id") Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("address", "id", addressId));
    }

    @PutMapping("/address/{id}")
    public address updateAddress(@PathVariable(value = "id")Long addressId,
                                 @Valid @RequestBody Supplier addressDetails){
        address address = addressRepository.findById(addressId)
                .orElseThrow(()-> new ResourceNotFoundException("address", "id", addressId));

//        supplier.setProductName(supplierDetails.getProductName());
//        supplier.setAddress(supplierDetails.getAddress());
//        supplier.setContact(supplierDetails.getContact());

        address updateAddress = addressRepository.save(address);
        return updateAddress;
    }


    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable(value = "id") Long addressId) {
        address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("address", "id", addressId));

        addressRepository.delete(address);

        return ResponseEntity.ok().build();
    }
}
