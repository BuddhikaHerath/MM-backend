package com.example.materialmanagement.controller;

import com.example.materialmanagement.exception.ResourceNotFoundException;
import com.example.materialmanagement.model.Supplier;
import com.example.materialmanagement.model.enquiry;
import com.example.materialmanagement.model.product;
import com.example.materialmanagement.repository.enquiryRepository;
import com.example.materialmanagement.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/api")
public class enquiryController {

    @Autowired
    enquiryRepository enquiryRepository;

    @GetMapping("/enquiry")
    public List<enquiry> getAllEnquiry(){
        return enquiryRepository.findAll();
    }

    @PostMapping("/enquiry")
    public enquiry createEnquiry(@Valid @RequestBody enquiry enquiry){
        return enquiryRepository.save(enquiry);
    }

    @GetMapping("/enquiry/{id}")
    public enquiry getNoteById(@PathVariable(value = "id") Long enquiryId) {
        return enquiryRepository.findById(enquiryId)
                .orElseThrow(() -> new ResourceNotFoundException("enquiry", "id", enquiryId));
    }

    @PutMapping("/enquiry/{id}")
    public enquiry updateEnquiry(@PathVariable(value = "id")Long enquiryId,
                                 @Valid @RequestBody enquiry enquiryDetails){
        enquiry enquiry = enquiryRepository.findById(enquiryId)
                .orElseThrow(()-> new ResourceNotFoundException("enquiry", "id", enquiryId));

//        supplier.setProductName(supplierDetails.getProductName());
//        supplier.setAddress(supplierDetails.getAddress());
//        supplier.setContact(supplierDetails.getContact());

        enquiry updateEnquiry = enquiryRepository.save(enquiry);
        return updateEnquiry;
    }


    @DeleteMapping("/enquiry/{id}")
    public ResponseEntity<?> deleteEnquiry(@PathVariable(value = "id") Long enquiryId) {
        enquiry enquiry = enquiryRepository.findById(enquiryId)
                .orElseThrow(() -> new ResourceNotFoundException("enquiry", "id", enquiryId));

        enquiryRepository.delete(enquiry);

        return ResponseEntity.ok().build();
    }
}
