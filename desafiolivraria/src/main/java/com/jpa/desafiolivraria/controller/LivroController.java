package com.jpa.desafiolivraria.controller;

import com.jpa.desafiolivraria.entities.LivroEntity;
import com.jpa.desafiolivraria.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public ResponseEntity<List<LivroEntity>> findAll() {
        List<LivroEntity> list = service.listarLivros();
        return ResponseEntity.ok().body(list);
    }
}
