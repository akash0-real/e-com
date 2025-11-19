package com.example.backend.controller;

import com.example.backend.model.Prod;
import com.example.backend.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProdController {
    private final ProdService service;

    @Autowired
    ProdController(ProdService service){
        this.service = service;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Prod>> getAllProd(){
         return new ResponseEntity<>(service.getAllProd(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Prod> getProd(@PathVariable int id){

        Prod prod = service.getProdById(id);
        if(prod != null)
            return new ResponseEntity<>(prod,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id){
        Prod prod = service.getProdById(id);
        if(prod != null && prod.getImageDate() != null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(prod.getImageType()))
                    .body(prod.getImageDate());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProd(@RequestPart("prod") Prod prod, @RequestPart("imageFile") MultipartFile imageFile){

        try {
            Prod prod1 = service.addProd(prod,imageFile);
            return new ResponseEntity<>(prod1,HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
