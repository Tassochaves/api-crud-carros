package com.dev.crud_carros.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.crud_carros.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

}