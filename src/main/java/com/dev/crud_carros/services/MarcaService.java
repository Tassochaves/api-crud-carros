package com.dev.crud_carros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.crud_carros.entities.Marca;
import com.dev.crud_carros.repositories.MarcaRepository;


@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public String save(Marca marca){
        this.marcaRepository.save(marca);
        return marca.getNome()+ ": Marca salvo com sucesso!";
    }

    public String update(Marca marca, long id){
        marca.setId(id);
        this.marcaRepository.save(marca);
        return marca.getNome()+ ": Marca alterado com sucesso!";
    }

    public String delete(long id){
        this.marcaRepository.deleteById(id);
        return "Marca deletado com sucesso!";
    }

    public List<Marca> listAll(){
        return this.marcaRepository.findAll();
    }

    public Marca findById(long id){
        Marca marca = this.marcaRepository.findById(id).get();
        return marca;
    }
}
