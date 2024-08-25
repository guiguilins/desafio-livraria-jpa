package com.jpa.desafiolivraria.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EletronicoEntity extends LivroEntity{
    private int tamanho;

    public EletronicoEntity() {
    }

    public EletronicoEntity(String titulo, String autores, String editora, float preco, int tamanho) {
        super(titulo, autores, editora, preco);
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return String.format("%s %-10d |", super.toString(), tamanho);
    }
}
