package com.jpa.desafiolivraria.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "impresso")
public class ImpressoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float frete;
    private int estoque;

    public ImpressoEntity() {
    }

    public ImpressoEntity(float frete, int estoque) {
        this.frete = frete;
        this.estoque = estoque;
    }

    public void adicionarEstoque() {
        estoque -= 1;
    }

    @Override
    public String toString() {
        return "Livros impressos {" +
                "frete=" + getFrete() +
                ", estoque=" + getEstoque() +
                '}';
    }
}


