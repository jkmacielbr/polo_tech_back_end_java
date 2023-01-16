package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produtos;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

import java.math.BigDecimal;

public class Filme extends Produtos {
    private static int id = 0;
    private String idGerada = "F";
    private String estudio, diretores, produtores;

    public Filme(int qantidade, String nome, BigDecimal preco, String genero, String estudio, String diretores, String produtores) {
        super(qantidade, nome, preco, genero);
        this.estudio = estudio;
        this.diretores = diretores;
        this.produtores = produtores;
        this.categoriaProduto = CategoriaDeProdutos.Filme;
        adicionarQuantidadeNoEstoque(qantidade);
        id += 1;
        this.idGerada = "F"+ id;
    }


    @Override
    public String toString() {
        return  "\t\t\t\t\t\t\t\t\t\t\t[Produto]" +
                "\nID = " + idGerada +
                super.toString() +
                "\nGenero = " + genero +
                "\t\t Estudio = " + estudio +
                "\t\tDiretores = " + diretores +
                "\t\t\t\tProdutores = " + produtores +"\n";
    }
}
