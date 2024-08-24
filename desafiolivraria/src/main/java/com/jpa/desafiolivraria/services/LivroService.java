package com.jpa.desafiolivraria.services;

import com.jpa.desafiolivraria.entities.LivroEntity;
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

}
