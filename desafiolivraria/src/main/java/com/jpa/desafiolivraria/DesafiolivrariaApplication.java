package com.jpa.desafiolivraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.jpa.desafiolivraria.services.MenuService;

@SpringBootApplication
public class DesafiolivrariaApplication {

	@Autowired
	private MenuService menuService;

	public static void main(String[] args) {
		SpringApplication.run(DesafiolivrariaApplication.class, args);
	}

	@Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            menuService.iniciarMenu();
        };
    }
}
