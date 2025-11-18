package com.example.backend.service;

import com.example.backend.model.Prod;
import com.example.backend.repo.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdService {
    private ProdRepo repo;
    @Autowired
    ProdService(ProdRepo repo){
        this.repo = repo;
    }

    public List<Prod> getAllProd(){
         return repo.findAll();
    }
    public Prod getProdById(int id){
        return repo.findById(id).orElse(new Prod());

    }

}
