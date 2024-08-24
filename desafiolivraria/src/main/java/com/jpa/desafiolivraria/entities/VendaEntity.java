package com.jpa.desafiolivraria.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "venda")

public class VendaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numVendas;
	private int numero;
	private String cliente;
	private float valor;
    
	public VendaEntity(int numVendas, int numero, String cliente, float valor) {
		this.numVendas = numVendas;
		this.numero = numero;
		this.cliente = cliente;
		this.valor = valor;
	}
    
}
