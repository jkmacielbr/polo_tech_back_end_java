package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.Funcionalidades;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;

import java.math.BigDecimal;

public class Jogo extends Produtos {

    private String genero, distribuidora, estudio;
    static int id = 0;
    public static int quantidadeEstoqueJogo;

    public Jogo(int quantidade, String nome, BigDecimal preco, String genero, String distribuidora, String estudio) {
        super(quantidade, nome, preco);
        this.genero = genero;
        this.distribuidora = distribuidora;
        this.estudio = estudio;
        categoriaProduto = CategoriaDeProdutos.Jogo;
        Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, categoriaProduto);
        id += 1;
        this.idGerada = "J"+ id;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
    public static int getQuantidadeEstoqueJogo() {
        return quantidadeEstoqueJogo;
    }

    @Override
    public String toString() {
        return  "\t\t\t\t\t\t\t\t\t\t\t[Produto]" +
                "\nID = " + idGerada +
                super.toString() +
                "\nGenero = " + genero +
                "\t\tDistribuidora = " + distribuidora +
                "\t\tEtudio = " + estudio;
    }




}
