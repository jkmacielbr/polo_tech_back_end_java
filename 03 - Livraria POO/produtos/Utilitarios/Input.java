package br.com.americanas.polotechDesafios.livraria.produtos.Utilitarios;

import br.com.americanas.polotechDesafios.livraria.produtos.*;
import br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Input {
    int quantidade = 0;
    private String nome, genero;
    private BigDecimal preco;

    private String escritor, editora; //LIVROS
    private String distribuidora, estudioJogos; //JOGOS
    private String estudioFilmes, diretores, produtores; //FILMES
    private String musicasOuBandas, selos; //ALBUM MÚSICAS
    private String tipo; //BRINQUEDOS


    public void cadastrarProduto(int op) {
        if (op == 1) {
            receberDadosGeral(op);
            receberDadosAlbum();
            Produtos produtos = new Album(quantidade, nome, preco, genero, musicasOuBandas, selos);
            Produtos.cadastrarProduto(produtos);
        } else if (op == 2) {
            receberDadosGeral(op);
            receberDadosBrinquedo();
            Produtos produtos = new Brinquedo(quantidade, nome, preco, tipo);
            Produtos.cadastrarProduto(produtos);
        } else if (op == 3) {
            receberDadosGeral(op);
            receberDadosFilme();
            Produtos produtos = new Filme(quantidade, nome, preco, genero, estudioFilmes, diretores, produtores);
            Produtos.cadastrarProduto(produtos);
        } else if (op == 4) {
            receberDadosGeral(op);
            receberDadosjogo();
            Produtos produtos = new Jogo(quantidade, nome, preco, genero, distribuidora, estudioJogos);
            Produtos.cadastrarProduto(produtos);
        } else if (op == 5) {
            receberDadosGeral(op);
            receberDadosLivro();
            Produtos produtos = new Livro(quantidade, nome, preco, genero, escritor, editora);
            Produtos.cadastrarProduto(produtos);

        } else {
            System.out.println("OpcaoInválida");

        }
    }

    private void receberDadosGeral(int op) {
        Scanner tc = new Scanner(System.in);
        do {
            System.out.print("Quantidade: ");
            this.quantidade = ValidacaoDeInputs.inputIsvalido();
            if(this.quantidade <=0) System.out.println("\t[INFORMAR QUANTIDADE MAIOR QUE 0]");
        }while (this.quantidade <=0);
        System.out.print("Nome: ");
        this.nome = tc.nextLine();
        System.out.print("Preço: ");
        this.preco = BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido());
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
