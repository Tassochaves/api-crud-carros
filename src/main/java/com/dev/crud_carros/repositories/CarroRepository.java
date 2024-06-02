package com.dev.crud_carros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.crud_carros.entities.Carro;
import com.dev.crud_carros.entities.Marca;


public interface CarroRepository extends JpaRepository<Carro, Long>{

    public List<Carro> findByNome(String nome);

    public List<Carro> findByMarca(Marca marca);

    @Query("SELECT c FROM tb_carro c WHERE c.ano > :ano")
    public List<Carro> findAcimaDoAno(int ano);
}