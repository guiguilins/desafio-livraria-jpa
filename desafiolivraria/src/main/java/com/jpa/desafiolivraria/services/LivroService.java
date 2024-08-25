package com.jpa.desafiolivraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.desafiolivraria.entities.EletronicoEntity;
import com.jpa.desafiolivraria.entities.ImpressoEntity;
import com.jpa.desafiolivraria.entities.LivroEntity;
import com.jpa.desafiolivraria.repositories.LivroRepository;

@Service
public class LivroService {

    @Autowired
    LivroRepository repository;

    public List<ImpressoEntity> listarLivrosImpressos() {
    	return listarLivros().stream()
    			.filter(l -> l instanceof ImpressoEntity)
    			.map(l -> (ImpressoEntity) l)
    			.toList(); 
    }
    
    public List<EletronicoEntity> listarLivrosEletronicos() {
    	return listarLivros().stream()
    			.filter(l -> l instanceof EletronicoEntity)
    			.map(l -> (EletronicoEntity) l)
    			.toList(); 
    }
    
    
    public List<LivroEntity> listarLivros() {
        return repository.findAll();
    }

    public LivroEntity salvarLivro(LivroEntity livro) {
        return repository.save(livro);
    }

    public LivroEntity buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
