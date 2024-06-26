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

import com.dev.crud_carros.entities.Marca;
import com.dev.crud_carros.services.MarcaService;


@RestController
@RequestMapping("/api/marca")
@CrossOrigin("*")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Marca marca){

        try {
            String mensagem = this.marcaService.save(marca);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro encontrado: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Marca marca, @PathVariable long id){

        try {
            String mensagem = this.marcaService.update(marca, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro encontrado: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){

        try {
            String mensagem = this.marcaService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro encontrado: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("listAll")
    public ResponseEntity<List<Marca>> listAll(){

        try {
            List<Marca> result = this.marcaService.listAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Marca> findById(@PathVariable long id){

        try {
            Marca marca = this.marcaService.findById(id);
            return new ResponseEntity<>(marca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
