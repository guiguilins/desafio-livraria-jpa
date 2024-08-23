package com.jpa.desafiolivraria.repositories;

import com.jpa.desafiolivraria.entities.Impresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpressoRepository extends JpaRepository<Impresso, Long> {
}
