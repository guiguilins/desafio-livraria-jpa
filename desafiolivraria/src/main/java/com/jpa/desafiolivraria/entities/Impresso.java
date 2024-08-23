package com.jpa.desafiolivraria.entities;


import com.jpa.desafiolivraria.repositories.ImpressoRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "impresso")
public class Impresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float frete;
    private int estoque;

    public Impresso() {

    }

    public Impresso(float frete, int estoque) {

        this.frete = frete;
        this.estoque = estoque;
    }
}


