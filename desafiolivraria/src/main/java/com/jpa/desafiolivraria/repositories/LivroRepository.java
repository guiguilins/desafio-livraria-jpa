package com.jpa.desafiolivraria.repositories;

import com.jpa.desafiolivraria.entities.ImpressoEntity;
import com.jpa.desafiolivraria.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
}
