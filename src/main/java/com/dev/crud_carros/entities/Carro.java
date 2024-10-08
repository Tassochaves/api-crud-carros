package com.dev.crud_carros.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int ano;

    @ManyToOne
    @JsonIgnoreProperties("carros")
    private Marca marca;

    @ManyToMany
    @JoinTable(name = "tb_carro_proprietario")
    private List<Proprietario> proprietarios;

    @ManyToMany
    @JoinTable(name = "tb_carro_acessorio")
    private List<Acessorio> acessorios;
}
