package br.com.americanas.polotechDesafios.livraria.Utilitario;

import br.com.americanas.polotechDesafios.livraria.produtos.*;
import br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.*;

import java.util.Scanner;

public class Input {
    private String nome, preco, genero;
    private String escritor, editora; //LIVROS
    private String distribuidora, estudioJogos; //JOGOS
    private String estudioFilmes, diretores, produtores; //FILMES
    private String musicasOuBandas, selos; //ALBUM MÚSICAS
    private String tipo; //BRINQUEDOS


    public void cadastrarProduto(int op) {
        if (op == 1) {
            receberDadosGeral(op);
            receberDadosAlbum();
            Produto produto = new Album(nome, preco, genero, musicasOuBandas, selos);
            Produto.addProdutoNoArray(produto);
        } else if (op == 2) {
            receberDadosGeral(op);
            receberDadosBrinquedo();
            Produto produto = new Brinquedo(nome, preco, tipo);
            Produto.addProdutoNoArray(produto);
        } else if (op == 3) {
            receberDadosGeral(op);
            receberDadosFilme();
            Produto produto = new Filme(nome, preco, genero, estudioFilmes, diretores, produtores);
            Produto.addProdutoNoArray(produto);
        } else if (op == 4) {
            receberDadosGeral(op);
            receberDadosjogo();
            Produto produto = new Jogo(nome, preco, genero, distribuidora, estudioJogos);
            Produto.addProdutoNoArray(produto);
        } else if (op == 5) {
            receberDadosGeral(op);
            receberDadosLivro();
            Produto produto = new Livro(nome, preco, genero, escritor, editora);
            Produto.addProdutoNoArray(produto);

        } else {
            System.out.println("OpcaoInválida");
        }
    }

    private void receberDadosGeral(int op) {
        Scanner tc = new Scanner(System.in);
        System.out.print("Nome: ");
        this.nome = tc.nextLine();
        System.out.print("Preço: ");
        this.preco = tc.nextLine();
        if (op == 1 || op == 3 || op == 4 || op == 5) {
            System.out.print("Gênero: ");
            this.genero = tc.nextLine();
        }
    }

    private void receberDadosAlbum() {
        Scanner tc = new Scanner(System.in);
        System.out.print("Música ou Banda: ");
        this.musicasOuBandas = tc.nextLine();
        System.out.print("Selo: ");
        this.selos = tc.nextLine();
    }

    private void receberDadosBrinquedo() {
        Scanner tc = new Scanner(System.in);
        System.out.print("tipo: ");
        this.tipo = tc.nextLine();
    }

    private void receberDadosFilme() {
        Scanner tc = new Scanner(System.in);
        System.out.print("Estudio: ");
        this.estudioFilmes = tc.nextLine();
        System.out.print("Diretor: ");
        this.diretores = tc.nextLine();
        System.out.print("Produtor: ");
        this.produtores = tc.nextLine();
    }

    private void receberDadosjogo() {
        Scanner tc = new Scanner(System.in);
        System.out.print("Distribuidora: ");
        this.distribuidora = tc.nextLine();
        System.out.print("Estudio: ");
        this.estudioJogos = tc.nextLine();
    }

    private void receberDadosLivro() {
        Scanner tc = new Scanner(System.in);
        System.out.print("Escritor: ");
        this.escritor = tc.nextLine();
        System.out.print("Editora: ");
        this.editora = tc.nextLine();
    }


}
