package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produtos;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

import java.math.BigDecimal;

public class Album extends Produtos {

    private static int id = 0;

    private String musicaOuBanda, selos;

    public Album(int quantidade, String nome, BigDecimal preco, String genero, String musicaOuBanda, String selos) {
        super(quantidade, nome, preco, genero);
        this.musicaOuBanda = musicaOuBanda;
        this.selos = selos;
        this.categoriaProduto = CategoriaDeProdutos.Album;
        adicionarQuantidadeNoEstoque(quantidade);
        id += 1;
        this.idGerada = "A"+ id;

    }

    @Override
    public String toString() {
        return  "\t\t\t\t\t\t\t\t\t\t\t[Produto]" +
                "\nID = " + idGerada +
                super.toString() +
                "\nGenero = " + genero +
                "\t\tMúsica ou Banda = " + musicaOuBanda +
                "\t\t\t\tSelo = " + selos +"\n";
    }


}
