package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produto;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

public class Livro extends Produto {
    private static int id = 0;
    private String idGerada = "L";
    private String escritor, editora;

    public Livro(String nome, String preco, String genero, String escritor, String editora) {
        super(nome, preco, genero);
        this.categoriaProduto = CategoriaDeProdutos.Livro;
        id = id + 1;
        idGerada = idGerada + id;
        this.escritor = escritor;
        this.editora = editora;
    }

    @Override
    public String toString() {
        return  "\t[Produto]" +
                "\nID = " + idGerada +
                        "\n" + super.toString() +
                        "\nGenero = " + genero +
                        "\nEscritor = " + escritor +
                        "\nEditora = " + editora;
    }
}
