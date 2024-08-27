package com.jpa.desafiolivraria.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ImpressoEntity extends LivroEntity {
    private float frete;
    private int estoque;

    public ImpressoEntity(String titulo, String autores, String editora, float frete, float preco, int estoque) {
        super(titulo, autores, editora, preco);
        this.frete = frete;
        this.estoque = estoque;
    }

    public void adicionarEstoque() {
        estoque -= 1;
    }

    @Override
    public String toString() {
        return String.format("%s %-10.2f | %-10d |", super.toString(), frete, estoque);
    }
}


