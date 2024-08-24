package com.jpa.desafiolivraria.repositories;

import com.jpa.desafiolivraria.entities.VendaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Integer> {
}
