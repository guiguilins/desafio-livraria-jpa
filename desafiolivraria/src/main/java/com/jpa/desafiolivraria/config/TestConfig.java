package com.jpa.desafiolivraria.config;

import com.jpa.desafiolivraria.entities.EletronicoEntity;
import com.jpa.desafiolivraria.entities.ImpressoEntity;
import com.jpa.desafiolivraria.entities.LivroEntity;
import com.jpa.desafiolivraria.entities.VendaEntity;
import com.jpa.desafiolivraria.repositories.LivroRepository;
import com.jpa.desafiolivraria.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    public LivroRepository repository;

    @Override
    public void run(String... args) throws Exception {
        LivroEntity impresso = new ImpressoEntity("Harry Potter", "J. K. Rowling", "Rocco", 150, 30, 50);
        LivroEntity eletronico = new EletronicoEntity("Senhor dos Anéis", "J. R. R. Tolkien", "Rocco", 200, 2);


        repository.saveAll(Arrays.asList(impresso, eletronico));

        System.out.println(impresso);
        System.out.println(eletronico);

    }
}
