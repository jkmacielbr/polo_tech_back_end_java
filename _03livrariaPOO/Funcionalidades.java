package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.RecebeDadosDeCadastro;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos.*;

import java.math.BigDecimal;


public class Funcionalidades {
    public static int quantidade = 0;
    public static String nome, genero;
    public static BigDecimal preco;

    static public String escritor, editora; //LIVROS
    static public String distribuidora, estudioJogos; //JOGOS
    static public String estudioFilmes, diretores, produtores; //FILMES
    public static String musicasOuBandas, selos; //ALBUM MÚSICAS
    public static String tipo; //BRINQUEDOS

    public static void cadastrarProduto(int op) {
        if (op == 1) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosAlbum();
            Produtos produtoAlbum = new Album(quantidade, nome, preco, genero, musicasOuBandas, selos);
            Produtos.produto.add(produtoAlbum);
        } else if (op == 2) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosBrinquedo();
            Produtos produtoBrinquedo = new Brinquedo(quantidade, nome, preco, tipo);
            Produtos.produto.add(produtoBrinquedo);
        } else if (op == 3) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosFilme();
            Produtos produtoFilme = new Filme(quantidade, nome, preco, genero, estudioFilmes, diretores, produtores);
            Produtos.produto.add(produtoFilme);
        } else if (op == 4) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosjogo();
            Produtos produtoJogo = new Jogo(quantidade, nome, preco, genero, distribuidora, estudioJogos);
            Produtos.produto.add(produtoJogo);
        } else if (op == 5) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosLivro();
            Produtos produtoLivro = new Livro(quantidade, nome, preco, genero, escritor, editora);
            Produtos.produto.add(produtoLivro);

        } else {
            System.out.println("OpcaoInválida");

        }

        System.out.println("\t\t[CADASTRADO COMaaaaaaaaa SUCESSO]");


    }



}
