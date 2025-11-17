package com.example.backend.repo;

import com.example.backend.model.Prod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepo extends JpaRepository<Prod,Integer> {

}
