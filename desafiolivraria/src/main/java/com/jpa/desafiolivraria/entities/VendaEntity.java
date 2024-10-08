package com.jpa.desafiolivraria.entities;

import java.util.ArrayList;
import java.util.List;

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
	private Long id;
	private static int numVendas = 0;
	private int numero;
	private String cliente;
	private float valor;

	@OneToMany
	private List<LivroEntity> livros = new ArrayList<>();

	public VendaEntity(String cliente, float valor) {
		this.cliente = cliente;
		this.valor = valor;
		numVendas++;
		this.numero = numVendas;
	}

	public int getNumVendas() {
		return numVendas;
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

	public List<LivroEntity> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroEntity> titulo) {
		this.livros = titulo;
	}
	
	public void addLivro(LivroEntity livro, int index) {
		if (index >= 0 && index <= livros.size()) {
            livros.add(index, livro);
        } else {
        	livros.add(livro);
        }
	}

	public void listarLivros(VendaEntity venda) {
		List<LivroEntity> livrosDaVenda = venda.getLivros();

		if (livrosDaVenda.isEmpty()) {
			System.out.println("Nenhum livro foi adicionado a esta venda.");
		} else {
			System.out.println("Livros nesta venda:");
			for (int i = 0; i < livrosDaVenda.size(); i++) {
				LivroEntity livro = livrosDaVenda.get(i);
				System.out.println((i + 1) + ": " + livro.getTitulo() + " - Preço: " + livro.getPreco());
			}
		}
	}

	@Override
	public String toString() {
		return String.format("| %-20d | %-10.2f | %-20d | %-20s |", numero, valor, id, cliente);
	}
}
