package com.jpa.desafiolivraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jpa.desafiolivraria.entities.EletronicoEntity;
import com.jpa.desafiolivraria.entities.ImpressoEntity;
import com.jpa.desafiolivraria.entities.LivroEntity;
import com.jpa.desafiolivraria.entities.VendaEntity;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuService {

    @Autowired
    private LivrariaVirtualService livrariaService;
    private ApplicationContext applicationContext;

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
                	realizarVenda();
                    break;
                case 3:
                    listarLivro();
                    break;
                case 4:
                    listarVendas();
                    break;
                case 0:
                    rodando = false;
                    System.out.println("\nEncerrando o programa.");
                    encerrarAplicacao();
                    break;
                default:
                    System.out.println("\nOpção Inválida.");
            }
        }

        scanner.close();
    }

    private void listarVendas() {
        System.out.println("\nListagem dos Livros Vendidos:");
        List<VendaEntity> livrosVendidos = livrariaService.listarVendas();

        if (livrosVendidos.isEmpty()) {
            System.out.println("\nNenhum livro vendido.");
            return;
        }

        System.out.println("\n Vendas realizadas:\n");
        System.out.println("| Número               | Valor      | Id                   | Cliente              |");
        System.out.println("-----------------------------------------------------------------------------------");
        livrosVendidos.forEach(System.out::println);

    }

    private void realizarVenda() {
        System.out.print("\nNome do cliente: ");
        String cliente = scanner.nextLine();

        System.out.print("\nQuantidade de livros que deseja comprar: ");
        int quantidadeLivros = scanner.nextInt();
        scanner.nextLine();
        if(quantidadeLivros < 1) {
            System.out.println("A quantidade de livros deve ser maior que 1");
            return;
        }
        float valorFinal = 0;

        VendaEntity venda = new VendaEntity(cliente, 0);

        for (int i = 0; i < quantidadeLivros; i++) {
            System.out.println("\nEscolha o tipo de livro:");
            System.out.println("1. Impresso");
            System.out.println("2. Eletrônico");
            System.out.print("Opção: ");
            int tipoLivro = scanner.nextInt();
            scanner.nextLine();

            LivroEntity livroEscolhido = null;

            if (tipoLivro == 1) {
                List<ImpressoEntity> livrosImpressos = livrariaService.listarLivrosImpressos();
                exibirLivros(livrosImpressos);

                System.out.print("Escolha o índice do livro: ");
                int indiceLivro = scanner.nextInt();
                scanner.nextLine();

                if (indiceLivro >= 1 && indiceLivro <= livrosImpressos.size()) {
                    livroEscolhido = livrosImpressos.get(indiceLivro - 1);
                } else {
                    System.out.println("Índice inválido. Tente novamente.");
                    i--;
                    continue;
                }

            } else if (tipoLivro == 2) {
                List<EletronicoEntity> livrosEletronicos = livrariaService.listarLivrosEletronicos();
                exibirLivros(livrosEletronicos);

                System.out.print("Escolha o índice do livro: ");
                int indiceLivro = scanner.nextInt();
                scanner.nextLine();

                if (indiceLivro >= 1 && indiceLivro <= livrosEletronicos.size()) {
                    livroEscolhido = livrosEletronicos.get(indiceLivro - 1);
                } else {
                    System.out.println("Índice inválido. Tente novamente.");
                    i--;
                    continue;
                }

            } else {
                System.out.println("Tipo de livro inválido. Tente novamente.");
                i--;
                continue;
            }

            boolean jaAdicionado = false;
            for (LivroEntity livro : venda.getLivros()) {
                if (livro.getId().equals(livroEscolhido.getId())) {
                    jaAdicionado = true;
                    break;
                }
            }

            if (jaAdicionado) {
                System.out.println("Você já adicionou este livro a compra.");
                i--;
            } else {
                venda.addLivro(livroEscolhido, venda.getLivros().size());
                valorFinal += livroEscolhido.getPreco();
            }
        }

        venda.setValor(valorFinal);
        livrariaService.realizarVenda(venda);
        venda.listarLivros(venda);
        System.out.println();
        System.out.println("Obrigado pela compra!");
    }

    private void exibirLivros(List<? extends LivroEntity> livros) {
		   for (int i = 0; i < livros.size(); i++) {
		       System.out.println((i + 1) + ": " + livros.get(i).getTitulo());
		   }
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
            livrariaService.cadastrarLivro(livroImpresso);

            System.out.println("\nLivro impresso cadastrado com sucesso!");
        } else if (tipoLivro == 2) {
            System.out.print("Tamanho: ");
            int tamanho = scanner.nextInt();
            scanner.nextLine();

            EletronicoEntity livroEletronico = new EletronicoEntity(titulo, autores, editora, preco, tamanho);
            livrariaService.cadastrarLivro(livroEletronico);

            System.out.println("\nLivro eletrônico cadastrado com sucesso!");
        }
    }

    private void listarLivro() {
        System.out.println("\nEscolha o tipo de livro para listar:");
        System.out.println("1. Impresso");
        System.out.println("2. Eletrônico");
        System.out.print("Opção: ");
        String tipoLivro = scanner.nextLine();

        if (tipoLivro.equals("1")) {
            List<ImpressoEntity> livrosImpressos = livrariaService.listarLivrosImpressos();
            if (livrosImpressos.isEmpty()) {
                System.out.println("\nNenhum livro impresso cadastrado.");
                return;
            }

            System.out.println("\nLista de Livros Impressos:\n");
            System.out.println("| Título               | Autores              | Editora              | Preço      | Frete      | Estoque    |");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            livrosImpressos.forEach(System.out::println);
        } else if (tipoLivro.equals("2")) {
            List<EletronicoEntity> livrosEletronicos = livrariaService.listarLivrosEletronicos();
            if (livrosEletronicos.isEmpty()) {
                System.out.println("\nNenhum livro eletrônico cadastrado.");
                return;
            }

            System.out.println("\nLista de Livros Eletrônicos:\n");
            System.out.println("| Título               | Autores              | Editora              | Preço      | Tamanho    |");
            System.out.println("------------------------------------------------------------------------------------------------");
            livrosEletronicos.forEach(System.out::println);
        } else {
            System.out.println("\nOpção inválida. Retornando ao menu principal.");
        }
    }

    private void encerrarAplicacao() {
        SpringApplication.exit(applicationContext, () -> 0);
    }
}