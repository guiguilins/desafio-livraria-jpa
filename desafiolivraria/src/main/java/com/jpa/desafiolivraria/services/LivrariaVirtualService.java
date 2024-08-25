package com.jpa.desafiolivraria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.desafiolivraria.entities.EletronicoEntity;
import com.jpa.desafiolivraria.entities.ImpressoEntity;
import com.jpa.desafiolivraria.entities.LivroEntity;
import com.jpa.desafiolivraria.entities.VendaEntity;

import jakarta.persistence.OneToMany;

@Service
public class LivrariaVirtualService {
    public static final int MAX_IMPRESSOS = 10;
    public static final int MAX_ELETRONICOS = 20;
    public static final int MAX_VENDAS = 50;

    @OneToMany
    private List<ImpressoEntity> impressos = new ArrayList<>();

    @OneToMany
    private List<EletronicoEntity> eletronicos = new ArrayList<>();

    @OneToMany
    private List<VendaEntity> vendas = new ArrayList<>();
    
    @Autowired
    private LivroService serviceLivro;
    
    @Autowired
    private VendaService serviceVenda;
    
    public void cadastrarLivro(LivroEntity livro) {

    	List<LivroEntity> livros = serviceLivro.listarLivros();
        long numImpressos = livros.stream().filter(l -> l instanceof ImpressoEntity).count();
        long numEletronicos = livros.stream().filter(l -> l instanceof EletronicoEntity).count();

        if (livro instanceof ImpressoEntity && numImpressos >= MAX_IMPRESSOS) {
            throw new RuntimeException("Número máximo de livros impressos atingido.");
        } else if (livro instanceof EletronicoEntity && numEletronicos >= MAX_ELETRONICOS) {
            throw new RuntimeException("Número máximo de livros eletrônicos atingido.");
        }

        serviceLivro.salvarLivro(livro);
    
    }

    public void realizarVenda(VendaEntity venda) {
    	List <VendaEntity> vendas = serviceVenda.listarVendas();
    	
    	if(vendas.size() >= MAX_VENDAS) {
    		throw new RuntimeException("Número de vendas máximo atingido");
    	}
    	
    	serviceVenda.realizarVenda(venda);
    }
    
    public List<ImpressoEntity> listarLivrosImpressos() {
        return serviceLivro.listarLivrosImpressos();
    }

    public List<EletronicoEntity> listarLivrosEletronicos() {
    	return serviceLivro.listarLivrosEletronicos();
    }

    public List<LivroEntity> listarLivro() {
    	return serviceLivro.listarLivros();
    }
    
    public List<VendaEntity> listarVendas() {
    	return serviceVenda.listarVendas();
    }
    
}