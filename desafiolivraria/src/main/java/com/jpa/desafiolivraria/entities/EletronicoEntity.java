package com.jpa.desafiolivraria.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "eletronico")
public class EletronicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tamanho;


    @Override
    public String toString() {
        return "Livro eletronico [" +
                "tamanho=" + this.tamanho +
                "Kbps]";
    }
}
