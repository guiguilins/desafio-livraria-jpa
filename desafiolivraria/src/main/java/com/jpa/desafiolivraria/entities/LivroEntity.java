package com.jpa.desafiolivraria.entities;

import jakarta.persistence.*;

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
		return String.format("| %-20s | %-20s | %-20s | %-10.2f |", titulo, autores, editora, preco);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
    
    
}
