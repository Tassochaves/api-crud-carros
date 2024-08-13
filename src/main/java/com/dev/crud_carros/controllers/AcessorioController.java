package com.dev.crud_carros.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crud_carros.entities.Acessorio;
import com.dev.crud_carros.services.AcessorioService;


@RestController
@RequestMapping("/api/acessorio")
@CrossOrigin("*")
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Acessorio acessorio){

        try {
            String mensagem = this.acessorioService.save(acessorio);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro encontrado: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Acessorio acessorio, @PathVariable long id){

        try {
            String mensagem = this.acessorioService.update(acessorio, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro encontrado: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){

        try {
            String mensagem = this.acessorioService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro encontrado: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("listAll")
    public ResponseEntity<List<Acessorio>> listAll(){

        try {
            List<Acessorio> result = this.acessorioService.listAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Acessorio> findById(@PathVariable long id){

        try {
            Acessorio acessorio = this.acessorioService.findById(id);
            return new ResponseEntity<>(acessorio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
