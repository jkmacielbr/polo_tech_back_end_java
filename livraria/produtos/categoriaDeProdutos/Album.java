package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produto;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

public class Album extends Produto {

    private static int id = 0;
    private String idGerada = "A";

    private String musicaOuBanda, selos;

    public Album(int quantidade, String nome, String preco, String genero, String musicaOuBanda, String selos) {
        super(quantidade, nome, preco, genero);
        id = id + 1;
        idGerada = idGerada +id;
        this.musicaOuBanda = musicaOuBanda;
        this.selos = selos;
        this.categoriaProduto = CategoriaDeProdutos.Album;
        adicionarQuantidadeNoEstoque(quantidade);

    }

    @Override
    public String toString() {
        return  "\t[Produto]" +
                        "\nID = " + idGerada +
                        "\n" + super.toString() +
                        "\nMusica ou Banda = " + musicaOuBanda +
                        "\nSelo = " + selos;
    }


}
