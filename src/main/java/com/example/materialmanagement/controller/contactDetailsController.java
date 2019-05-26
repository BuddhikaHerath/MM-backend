package com.example.materialmanagement.controller;

import com.example.materialmanagement.exception.ResourceNotFoundException;
import com.example.materialmanagement.model.Supplier;
import com.example.materialmanagement.model.contactDetails;
import com.example.materialmanagement.model.product;
import com.example.materialmanagement.repository.contactDetailsRepository;
import com.example.materialmanagement.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class contactDetailsController {

    @Autowired
    contactDetailsRepository contactDetailsRepository;

    @GetMapping("/contactDetails")
    public List<contactDetails> getAllContactDetails() {
        return contactDetailsRepository.findAll();
    }

    @PostMapping("/contactDetails")
    public contactDetails createcontactDetails(@Valid @RequestBody contactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }

    @GetMapping("/contactDetails/{id}")
    public contactDetails getNoteById(@PathVariable(value = "id") Long contactDetailsId) {
        return contactDetailsRepository.findById(contactDetailsId)
                .orElseThrow(() -> new ResourceNotFoundException("contactDetail", "id", contactDetailsId));
    }

    @PutMapping("/contactDetails/{id}")
    public contactDetails updatecontactDetails(@PathVariable(value = "id") Long contactDetailsId,
                                 @Valid @RequestBody contactDetails contactDetails) {
        contactDetails contactDetails1 = contactDetailsRepository.findById(contactDetailsId)
                .orElseThrow(() -> new ResourceNotFoundException("contactDetail", "id", contactDetailsId));

//        supplier.setProductName(supplierDetails.getProductName());
//        supplier.setAddress(supplierDetails.getAddress());
//        supplier.setContact(supplierDetails.getContact());

        contactDetails updateContact = contactDetailsRepository.save(contactDetails);
        return updateContact;
    }


    @DeleteMapping("/contactDetails/{id}")
    public ResponseEntity<?> deleteContactDetails(@PathVariable(value = "id") Long contactDetailsId) {
        contactDetails contactDetails = contactDetailsRepository.findById(contactDetailsId)
                .orElseThrow(() -> new ResourceNotFoundException("contactDetails", "id", contactDetailsId));

        contactDetailsRepository.delete(contactDetails);

        return ResponseEntity.ok().build();
    }

}
