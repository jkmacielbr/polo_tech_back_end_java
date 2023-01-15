package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produto;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

public class Filme extends Produto {
    private static int id = 0;
    private String idGerada = "F";
    private String estudio, diretores, produtores;

    public Filme(int qantidade, String nome, String preco, String genero, String estudio, String diretores, String produtores) {
        super(qantidade, nome, preco, genero);
        id = id + 1;
        idGerada = idGerada + id;
        this.estudio = estudio;
        this.diretores = diretores;
        this.produtores = produtores;
        this.categoriaProduto = CategoriaDeProdutos.Filme;
        adicionarQuantidadeNoEstoque(qantidade);
    }
    @Override
    public String toString() {
        return "\t[Produto]" +
                        "\nID = " + idGerada +
                        "\n" + super.toString() +
                        "\nEstudio = " + estudio +
                        "\nDiretores = " + diretores +
                        "\nProdutores = " + produtores;
    }
}
