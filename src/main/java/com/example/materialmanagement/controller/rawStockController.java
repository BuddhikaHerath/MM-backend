package com.example.materialmanagement.controller;

import com.example.materialmanagement.exception.ResourceNotFoundException;
import com.example.materialmanagement.model.User;
import com.example.materialmanagement.model.rawStockProduct;
import com.example.materialmanagement.repository.rawStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class rawStockController {

    @Autowired
    rawStockRepository rawStockRepository;

    @GetMapping("/rawStock")
    public List<rawStockProduct> getAllUsers(){
        return rawStockRepository.findAll();
    }

    @PostMapping("/rawStock")
    public rawStockProduct createUser(@Valid @RequestBody rawStockProduct rawStockProduct){
        return rawStockRepository.save(rawStockProduct);
    }

    @GetMapping("/rawStock/{id}")
    public rawStockProduct getNoteById(@PathVariable(value = "id") Long rawStockId) {
        return rawStockRepository.findById(rawStockId)
                .orElseThrow(() -> new ResourceNotFoundException("RawStock", "id", rawStockId));
    }

    @PutMapping("/rawStock/{id}")
    public rawStockProduct rawStockProduct(@PathVariable(value = "id")Long rawStockId,
                           @Valid @RequestBody rawStockProduct rawStockDetails){
        rawStockProduct rawStockProduct = rawStockRepository.findById(rawStockId)
                .orElseThrow(()-> new ResourceNotFoundException("rawStock", "id", rawStockId));

//        user.setEmail(userDetails.getEmail());
//        user.setUsername(userDetails.getUsername());
//        user.setPassword(userDetails.getPassword());

        rawStockProduct rawStockProduct1 = rawStockRepository.save(rawStockProduct);
        return rawStockProduct1;
    }


    @DeleteMapping("/rawStock/{id}")
    public ResponseEntity<?> deleteRawStock(@PathVariable(value = "id") Long rawStockId) {
        rawStockProduct rawStockProduct = rawStockRepository.findById(rawStockId)
                .orElseThrow(() -> new ResourceNotFoundException("rawStock", "id", rawStockId));

        rawStockRepository.delete(rawStockProduct);

        return ResponseEntity.ok().build();
    }


}
