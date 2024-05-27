package com.dev.crud_carros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.crud_carros.entities.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

    
}