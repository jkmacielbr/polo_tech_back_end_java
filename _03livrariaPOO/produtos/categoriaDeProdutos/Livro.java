package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Funcionalidades;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;

import java.math.BigDecimal;

public class Livro extends Produtos {
    public String escritor, editora, genero;
    private static int id = 0;
    public static int quantidadeEstoqueLivro;

    public Livro(int quantidade, String nome, BigDecimal preco, String genero, String escritor, String editora) {
        super(quantidade, nome, preco);
        this.genero = genero;
        categoriaProduto = CategoriaDeProdutos.Livro;
        this.escritor = escritor;
        this.editora = editora;
        Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, categoriaProduto);
        id += 1;
        this.idGerada = "L" + id;

    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    public static int getQuantidadeEstoqueLivro() {
        return quantidadeEstoqueLivro;
    }

    @Override
    public String toString() {
        return  "\t\t\t\t\t\t\t\t\t\t\t[Produto]" +
                        "\nID = " + idGerada +
                            super.toString() +
                        "\nGenero = " + genero +
                        "\t\tEscritor = " + escritor +
                        "\t\t\t\tEditora = " + editora +"\n";
    }
}
