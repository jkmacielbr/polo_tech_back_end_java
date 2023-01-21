package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos;


import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.GeradorDeData;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Produtos {

    protected static int id = 0;
    public static int quantidadeEstoqueTotal, quantidadeEstoqueAlbum, quantidadeEstoqueBrinquedo,
            quantidadeEstoqueFilme, quantidadeEstoqueJogo, quantidadeEstoqueLivro;
    public int quantidade;
    public String nome;
    public String idGerada;
    public BigDecimal preco;
    public  CategoriaDeProdutos categoriaProduto;
    public String genero;
    public String dataDeCadastro;
    public static BigDecimal valorDeVendas = new BigDecimal("0.00");
    protected DecimalFormat formatarPreco = new DecimalFormat("0.00");
    public static ArrayList<Produtos> produto = new ArrayList<>();

    public Produtos(int quantidade, String nome, BigDecimal preco) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());
    }

    public Produtos(int quantidade, String nome, BigDecimal preco, String genero) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());
        this.genero = genero;

    }


    public String getNome() {
        return nome;
    }

    public String getIdgerada() {
        return idGerada;
    }

    public static int getQuantidadeEstoqueTotal() {
        return quantidadeEstoqueTotal;
    }

    public static int getQuantidadeEstoqueAlbum() {
        return quantidadeEstoqueAlbum;
    }

    public static int getQuantidadeEstoqueBrinquedo() {
        return quantidadeEstoqueBrinquedo;
    }

    public static int getQuantidadeEstoqueFilme() {
        return quantidadeEstoqueFilme;
    }

    public static int getQuantidadeEstoqueJogo() {
        return quantidadeEstoqueJogo;
    }

    public static int getQuantidadeEstoqueLivro() {
        return quantidadeEstoqueLivro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public static BigDecimal getValorDeVendas() {
        return valorDeVendas;
    }

    @Override
    public String toString() {
        return
                "\t\t\t\t\tCategoria = " + categoriaProduto +
                        "\t\t\tQuantidade = " + quantidade +
                        "\t\t\tÚltima atualização = " + dataDeCadastro +
                        "\nNome = " + nome +
                        "\t\t\tPreço = R$" + formatarPreco.format(preco) +
                        "\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t[Mais Informações]";

    }

}
