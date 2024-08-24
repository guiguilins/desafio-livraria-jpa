package com.jpa.desafiolivraria.services;

import com.jpa.desafiolivraria.entities.VendaEntity;
import com.jpa.desafiolivraria.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    VendaRepository repository;

    public List<VendaEntity> listarVendas() {
        return repository.findAll();
    }
}
