package com.jpa.desafiolivraria.controller;

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


    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroEntity> buscarPorId(@PathVariable Long id) {
        LivroEntity obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<LivroEntity> salvarLivro(@RequestBody LivroEntity obj) {
        obj = service.salvarLivro(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
