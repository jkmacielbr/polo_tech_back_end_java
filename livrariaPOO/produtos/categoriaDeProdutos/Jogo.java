package br.com.americanas.desafios.polo_tech_back_end_java.livrariaPOO.produtos.categoriaDeProdutos;

import br.com.americanas.desafios.polo_tech_back_end_java.livrariaPOO.enumProdutos.CategoriaDeProdutos;
import br.com.americanas.desafios.polo_tech_back_end_java.livrariaPOO.produtos.Produtos;

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

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
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
