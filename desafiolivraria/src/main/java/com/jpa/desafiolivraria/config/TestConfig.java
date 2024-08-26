package com.jpa.desafiolivraria.config;

import com.jpa.desafiolivraria.entities.EletronicoEntity;
import com.jpa.desafiolivraria.entities.ImpressoEntity;
import com.jpa.desafiolivraria.entities.LivroEntity;
import com.jpa.desafiolivraria.repositories.LivroRepository;
import com.jpa.desafiolivraria.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    public LivroRepository repository;

    @Autowired
    public LivroService service;

    public void run(String... args) throws Exception {
        // Lê o arquivo do classpath
        Resource resource = new ClassPathResource("Livros/livros.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        String line;
        List<LivroEntity> livros = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            String tipo = data[6];
            if ("IMPRESSO".equalsIgnoreCase(tipo)) {
                LivroEntity impresso = new ImpressoEntity(data[0], data[1], data[2], (float) Integer.parseInt(data[3]), (float) Double.parseDouble(data[4]), (int) Double.parseDouble(data[5]));
                livros.add(impresso);
            } else if ("ELETRONICO".equalsIgnoreCase(tipo)) {
                LivroEntity eletronico = new EletronicoEntity(data[0], data[1], data[2], (float) Integer.parseInt(data[3]), (int) Double.parseDouble(data[4]));
                livros.add(eletronico);
            }
        }
        // Salva todos os livros de uma vez
        repository.saveAll(livros);

        // Chama o método listarLivros, se necessário
        service.listarLivros();
    }
}
