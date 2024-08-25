package com.jpa.desafiolivraria.controller;

import com.jpa.desafiolivraria.entities.EletronicoEntity;
import com.jpa.desafiolivraria.entities.ImpressoEntity;
import com.jpa.desafiolivraria.entities.LivroEntity;
import com.jpa.desafiolivraria.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public ResponseEntity<List<LivroEntity>> listarLivros() {
        List<LivroEntity> list = service.listarLivros();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/impressos")
    public ResponseEntity<List<ImpressoEntity>> listarLivrosImpressos() {
        List<ImpressoEntity> list = service.listarLivrosImpressos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/eletronicos")
    public ResponseEntity<List<EletronicoEntity>> listarLivrosEletronicos() {
        List<EletronicoEntity> list = service.listarLivrosEletronicos();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<LivroEntity> salvarLivro(@RequestBody LivroEntity obj) {
        obj = service.salvarLivro(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
