package com.example.mockfirstweek.controller;

import com.example.mockfirstweek.model.Product;
import com.example.mockfirstweek.reponsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/customer")
public class CustomerController {
    @Autowired
    private ProductRepository repo;
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Product>> getAll(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/getinfo/{id}")
    public ResponseEntity<Product> getInfo(@PathVariable String id){
        Optional<Product> userOptional=repo.findById(id);
        return userOptional.map(product -> new ResponseEntity<>(product,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
