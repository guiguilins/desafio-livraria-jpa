package com.jpa.desafiolivraria.repositories;

import com.jpa.desafiolivraria.entities.ImpressoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpressoRepository extends JpaRepository<ImpressoEntity, Long> {
}
