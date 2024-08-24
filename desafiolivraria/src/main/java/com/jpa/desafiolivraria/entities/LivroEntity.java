package com.jpa.desafiolivraria.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "livro")

public class LivroEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String titulo;
    private String autores;
    private String editora;
    private float preco;
    
    public LivroEntity () {
    	
    }
    
	public LivroEntity(String titulo, String autores, String editora, float preco) {
		this.titulo = titulo;
		this.autores = autores;
		this.editora = editora;
		this.preco = preco;
	}
    
	public String toString() {
		return "Livro: " + this.titulo + " - " + this.autores + " - " + this.editora + " - " + this.preco;
	}
    
    
}
