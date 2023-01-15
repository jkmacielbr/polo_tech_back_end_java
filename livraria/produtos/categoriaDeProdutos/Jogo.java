package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produto;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

public class Jogo extends Produto {

    private static int id = 0;
    private String idGerada = "J";
    private String distribuidora, estudio;

    public Jogo(int quantidade,String nome, String preco, String genero, String distribuidora, String estudio) {
        super(quantidade, nome, preco, genero);
        id = id + 1;
        idGerada = idGerada + id;
        this.distribuidora = distribuidora;
        this.estudio = estudio;
        this.categoriaProduto = CategoriaDeProdutos.Jogo;
        adicionarQuantidadeNoEstoque(quantidade);
    }

    @Override
    public String toString() {
        return  "\t[Produto]" +
                        "\nID = " + idGerada +
                        "\n" + super.toString() +
                        "\nDistribuidora = " + distribuidora +
                        "\nEstudio = " + estudio;
    }
}
