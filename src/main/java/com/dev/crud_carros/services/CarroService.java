package com.dev.crud_carros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.crud_carros.entities.Carro;
import com.dev.crud_carros.repositories.CarroRepository;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro){
        this.carroRepository.save(carro);
        return "Carro salvo com sucesso!";
    }

    public String update(Carro carro, long id){
        carro.setId(id);
        this.carroRepository.save(carro);
        return "Carro alterado com sucesso!";
    }

    public String delete(long id){
        this.carroRepository.deleteById(id);
        return "Carro deletado com sucesso!";
    }

    public List<Carro> findAll(){

        List<Carro> lista = this.carroRepository.findAll();
        return lista;
    }

    public Carro findById(long id){
        Carro carro = this.carroRepository.findById(id).get();
        return carro;
    }
}
