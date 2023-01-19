package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;

import java.math.BigDecimal;

public class Brinquedo extends Produtos {

    private static int id = 0;
    private String tipo;

    public Brinquedo(int quantidade, String nome, BigDecimal preco, String tipo) {
        super(quantidade, nome, preco);
        this.tipo = tipo;
        this.categoriaProduto = CategoriaDeProdutos.Brinquedo;
        adicionarQuantidadeNoEstoque(quantidade);
        id += 1;
        this.idGerada = "B"+ id;

    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "\t\t\t\t\t\t\t\t\t\t\t\t\t\t[Produto]" +
                "\nID = " + idGerada +
                super.toString() +
                "\nTipo = " + tipo;
    }
}
