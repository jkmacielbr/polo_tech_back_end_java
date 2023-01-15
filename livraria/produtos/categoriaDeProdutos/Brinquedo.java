package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produto;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

public class Brinquedo extends Produto {

    private static int id = 0;
    private String idGerada = "B";
    private String tipo;

    public Brinquedo(int quantidade, String nome, String preco, String tipo) {
        super(quantidade, nome, preco);
        id = id + 1;
        idGerada = idGerada + id;
        this.tipo = tipo;
        this.categoriaProduto = CategoriaDeProdutos.Brinquedo;
        adicionarQuantidadeNoEstoque(quantidade);
    }

    @Override
    public String toString() {
        return  "\t[Produto]" +
                        "\nID = " + idGerada +
                        "\n" + super.toString() +
                        "\nTipo = " + tipo;
    }
}
