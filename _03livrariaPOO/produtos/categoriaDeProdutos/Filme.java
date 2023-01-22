package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.Funcionalidades;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;

import java.math.BigDecimal;

public class Filme extends Produtos {
    private static int id = 0;
    public static int quantidadeEstoqueFilme;
    private String genero, estudio, diretores, produtores;

    public Filme(int qantidade, String nome, BigDecimal preco, String genero, String estudio, String diretores, String produtores) {
        super(qantidade, nome, preco);
        this.genero = genero;
        this.estudio = estudio;
        this.diretores = diretores;
        this.produtores = produtores;
        categoriaProduto = CategoriaDeProdutos.Filme;
        Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, categoriaProduto);
        id += 1;
        this.idGerada = "F" + id;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public void setDiretores(String diretores) {
        this.diretores = diretores;
    }

    public void setProdutores(String produtores) {
        this.produtores = produtores;
    }

    public static int getQuantidadeEstoqueFilme() {
        return quantidadeEstoqueFilme;
    }

    @Override
    public String toString() {
        return "\t\t\t\t\t\t\t\t\t\t\t[Produto]" +
                "\nID = " + idGerada +
                super.toString() +
                "\nGenero = " + genero +
                "\t\t Estudio = " + estudio +
                "\t\tDiretores = " + diretores +
                "\t\t\t\tProdutores = " + produtores + "\n";
    }
}
