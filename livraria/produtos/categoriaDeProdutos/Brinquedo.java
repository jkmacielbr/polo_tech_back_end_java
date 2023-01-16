package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produtos;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public String toString() {
        return  "\t\t\t\t\t\t\t\t\t\t\t[Produto]" +
                "\nID = " + idGerada +
                super.toString() +
                "\nTipo = " + tipo;
    }
}
