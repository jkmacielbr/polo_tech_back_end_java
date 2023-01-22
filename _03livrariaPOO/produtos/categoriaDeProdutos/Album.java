package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.Funcionalidades;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;

import java.math.BigDecimal;

public class Album extends Produtos {

    private static int id = 0;
    public static  int quantidadeEstoqueAlbum;

    private String musicaOuBanda, selos, genero;

    public Album(int quantidade, String nome, BigDecimal preco, String genero, String musicaOuBanda, String selos) {
        super(quantidade, nome, preco);
        this.genero = genero;
        this.musicaOuBanda = musicaOuBanda;
        this.selos = selos;
        categoriaProduto = CategoriaDeProdutos.Album;
        Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, categoriaProduto);
        id += 1;
        this.idGerada = "A"+ id;

    }

    public void setMusicaOuBanda(String musicaOuBanda) {
        this.musicaOuBanda = musicaOuBanda;
    }

    public void setSelos(String selos) {
        this.selos = selos;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public static int getQuantidadeEstoqueAlbum() {
        return quantidadeEstoqueAlbum;
    }

    @Override
    public String toString() {
        return  "\t\t\t\t\t\t\t\t\t\t\t\t\t\t[Produto]" +
                "\nID = " + idGerada +
                super.toString() +
                "\nGenero = " + genero +
                "\t\tMúsica ou Banda = " + musicaOuBanda +
                "\t\t\t\tSelo = " + selos +"\n";
    }


}
