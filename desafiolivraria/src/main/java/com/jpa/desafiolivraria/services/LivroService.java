package com.jpa.desafiolivraria.services;

import com.jpa.desafiolivraria.entities.LivroEntity;
import com.jpa.desafiolivraria.entities.VendaEntity;
import com.jpa.desafiolivraria.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository repository;

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
