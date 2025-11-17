package com.example.backend.controller;

import com.example.backend.model.Prod;
import com.example.backend.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdController {
    private ProdService service;

    @Autowired
    ProdController(ProdService service){
        this.service = service;
    }

    @RequestMapping("/")
    public void one(){
        System.out.println("Hello from akash!");
    }

    @GetMapping("/products")
    public List<Prod> getAllProd(){
         return service.getAllProd();
    }
}
