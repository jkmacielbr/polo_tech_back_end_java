package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Funcionalidades;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;

import java.math.BigDecimal;

public class Album extends Produtos {

    private static int id = 0;

    private String musicaOuBanda, selos;

    public Album(int quantidade, String nome, BigDecimal preco, String genero, String musicaOuBanda, String selos) {
        super(quantidade, nome, preco, genero);
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
