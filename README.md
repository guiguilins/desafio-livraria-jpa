# Livraria Virtual

## Sumário

- [Introdução](#introdução)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação e Configuração](#instalação-e-configuração)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades](#funcionalidades)

## Introdução

O projeto proposto foi desenvolver uma livraria utilizando JPA. Após fazer alguns planejamentos, optou-se por utilizar Spring, pois além de nos auxiliar no desenvolvimento nos ajudaria aprender mais para os próximos projetos que estão por vir. Assim nesse projeto, utilizamos todos os conhecimentos adquiridos até aqui para desenvolver e entregar um projeto final utilizável.

## Tecnologias Utilizadas

- **Java**: versão 21
- **Spring Boot**: versão 3.3.3
- **Spring Data JPA**: para persistência de dados
- **Maven**: para gerenciamento de dependências
- **H2**: Banco de dados

## Instalação e Configuração

- **É necessário ter o H2 instalado.**
- **Para acessar o site, entre em localhost:8080/h2-console**
- **As configurações de login são as seguintes:**

![Screenshot_88](https://github.com/user-attachments/assets/44e485cd-18f6-4ecc-a86a-da4eead507fe)


### Pré-requisitos

- **Java 21** instalado
- **Maven** instalado

### Estrutura do Projeto

- O nosso projeto está organizado da seguinte maneira:

![Estrutura Projeto](https://github.com/user-attachments/assets/1a007b90-ea56-4706-b7ee-c58ef73ea37e)

### Funcionalidades

Como mostrado acima, dividimos nosso projeto em pacotes para manter a arquitetura e limpa e facilitar a manutenção. A estrutura geral está explicada acima; Então aqui vamos falar especificamente da parte mais importante, que é como fazer o projeto rodar. A classe responsável por isso é `MenuService`, que está dentro do pacote `service`, onde são realizadas as principais interações. São elas:

- **`cadastrarLivro`**: Registrar novos livros no estoque da loja.
- **`realizarVenda`**: Realizar a venda de um ou mais livros de acordo com a escolha do usuário.
- **`listarLivro`**: Permite ao usuário optar por ver todos os livros, apenas os livros impressos ou apenas os livros eletrônicos.
- **`listarVendas`**: Permite ao lojista ver todas as vendas realizadas.
