package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produtos;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

import java.math.BigDecimal;

public class Jogo extends Produtos {

    private String distribuidora, estudio;

    public Jogo(int quantidade, String nome, BigDecimal preco, String genero, String distribuidora, String estudio) {
        super(quantidade, nome, preco, genero);
        this.distribuidora = distribuidora;
        this.estudio = estudio;
        this.categoriaProduto = CategoriaDeProdutos.Jogo;
        adicionarQuantidadeNoEstoque(quantidade);
        id += 1;
        this.idGerada = "J"+ id;
    }

    @Override
    public String toString() {
        return  "\t\t\t\t\t\t\t\t\t\t\t[Produto]" +
                "\nID = " + idGerada +
                super.toString() +
                "\nDistribuidora = " + distribuidora +
                "\t\tEtudio = " + estudio;
    }




}
