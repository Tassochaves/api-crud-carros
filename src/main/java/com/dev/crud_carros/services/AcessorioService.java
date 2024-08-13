package com.dev.crud_carros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.crud_carros.entities.Acessorio;
import com.dev.crud_carros.repositories.AcessorioRepository;


@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public String save(Acessorio acessorio){
        this.acessorioRepository.save(acessorio);
        return acessorio.getNome()+ ": Acessorio salvo com sucesso!";
    }

    public String update(Acessorio acessorio, long id){
        acessorio.setId(id);
        this.acessorioRepository.save(acessorio);
        return acessorio.getNome()+ ": Acessorio alterado com sucesso!";
    }

    public String delete(long id){
        this.acessorioRepository.deleteById(id);
        return "Acessorio deletado com sucesso!";
    }

    public List<Acessorio> listAll(){
        return this.acessorioRepository.findAll();
    }

    public Acessorio findById(long id){
        Acessorio acessorio = this.acessorioRepository.findById(id).get();
        return acessorio;
    }
}
