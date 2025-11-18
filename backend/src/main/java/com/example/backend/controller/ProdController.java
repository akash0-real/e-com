package com.example.backend.controller;

import com.example.backend.model.Prod;
import com.example.backend.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProdController {
    private ProdService service;

    @Autowired
    ProdController(ProdService service){
        this.service = service;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Prod>> getAllProd(){
         return new ResponseEntity<>(service.getAllProd(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public Prod getProd(@PathVariable int id){
        return service.getProdById(id);
    }
}
