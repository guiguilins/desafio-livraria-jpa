package com.jpa.desafiolivraria.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "venda")
@NoArgsConstructor
public class VendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int numVendas;
	private int numero;
	private String cliente;
	private float valor;

	@ManyToOne
	private LivroEntity titulo;

	public VendaEntity(long id, int numVendas, int numero, String cliente, float valor) {
		this.id = id;
		this.numVendas = numVendas;
		this.numero = numero;
		this.cliente = cliente;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumVendas() {
		return numVendas;
	}

	public void setNumVendas(int numVendas) {
		this.numVendas = numVendas;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public LivroEntity getTitulo() {
		return titulo;
	}

	public void setTitulo(LivroEntity titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "VendaEntity{" +
				"id=" + id +
				", numVendas=" + numVendas +
				", numero=" + numero +
				", cliente='" + cliente + '\'' +
				", valor=" + valor +
				", titulo=" + titulo +
				'}';
	}
}
