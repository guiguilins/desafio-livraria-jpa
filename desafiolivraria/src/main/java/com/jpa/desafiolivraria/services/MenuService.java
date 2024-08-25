package com.jpa.desafiolivraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.desafiolivraria.entities.EletronicoEntity;
import com.jpa.desafiolivraria.entities.ImpressoEntity;
import com.jpa.desafiolivraria.entities.LivroEntity;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuService {

    @Autowired
    private LivroService livroService;

    Scanner scanner = new Scanner(System.in);

    public void iniciarMenu() {
        boolean rodando = true;

        while (rodando) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Realizar venda");
            System.out.println("3. Listar livros");
            System.out.println("4. Listar vendas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    
                    break;
                case 3:
                    listarLivros();
                    break;
                case 4:
                    
                    break;
                case 0:
                    rodando = false;
                    System.out.println("\nEncerrando o programa.");
                    break;
                default:
                    System.out.println("\nOpção Inválida.");
            }
        }

        scanner.close();
    }

    private void cadastrarLivro() {
        System.out.println("\nEscolha o tipo de livro:");
        System.out.println("1. Impresso");
        System.out.println("2. Eletrônico");
        System.out.println("0. Voltar");
        System.out.print("Opção: ");
        int tipoLivro = scanner.nextInt();
        scanner.nextLine();

        if (tipoLivro < 1 || tipoLivro > 2) {
            return;
        }

        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autores: ");
        String autores = scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Preço: ");
        float preco = scanner.nextFloat();
        scanner.nextLine();

        if (tipoLivro == 1) {
            System.out.print("Frete: ");
            float frete = scanner.nextFloat();
            System.out.print("Estoque: ");
            int estoque = scanner.nextInt();
            scanner.nextLine();

            ImpressoEntity livroImpresso = new ImpressoEntity(titulo, autores, editora, frete, preco, estoque);
            livroService.salvarLivro(livroImpresso);

            System.out.println("\nLivro impresso cadastrado com sucesso!");
        } else if (tipoLivro == 2) {
            System.out.print("Tamanho: ");
            int tamanho = scanner.nextInt();
            scanner.nextLine();

            EletronicoEntity livroEletronico = new EletronicoEntity(titulo, autores, editora, preco, tamanho);
            livroService.salvarLivro(livroEletronico);

            System.out.println("\nLivro eletrônico cadastrado com sucesso!");
        }
    }

    private void listarLivros() {
        System.out.println("\nEscolha o tipo de livro para listar:");
        System.out.println("1. Impresso");
        System.out.println("2. Eletrônico");
        System.out.print("Opção: ");
        String tipoLivro = scanner.nextLine();

        List<LivroEntity> livros = livroService.listarLivros();

        if (tipoLivro.equals("1")) {
            System.out.println("\nLista de Livros Impressos:\n");
            System.out.println("| Título               | Autores              | Editora              | Preço      | Frete      | Estoque    |");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            livros.stream()
                .filter(livro -> livro instanceof ImpressoEntity)
                .forEach(System.out::println);
        } else if (tipoLivro.equals("2")) {
            System.out.println("\nLista de Livros Eletrônicos:\n");
            System.out.println("| Título               | Autores              | Editora              | Preço      | Tamanho    |");
            System.out.println("------------------------------------------------------------------------------------------------");
            livros.stream()
                .filter(livro -> livro instanceof EletronicoEntity)
                .forEach(System.out::println);
        } else {
            System.out.println("Opção inválida. Retornando ao menu principal.");
        }
    }
}