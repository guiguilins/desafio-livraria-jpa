package com.jpa.desafiolivraria.controller;


import com.jpa.desafiolivraria.entities.VendaEntity;
import com.jpa.desafiolivraria.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/venda")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping(value = "/")
    public ResponseEntity<List<VendaEntity>> findAll() {
        List<VendaEntity> list = service.listarVendas();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendaEntity> buscarPorId(@PathVariable Long id) {
        VendaEntity obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<VendaEntity> realizarCadastro(@RequestBody VendaEntity obj) {
        obj = service.realizarVenda(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
