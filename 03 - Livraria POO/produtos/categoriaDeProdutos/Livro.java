package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos;

import br.com.americanas.polotechDesafios.livraria.produtos.Produtos;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

import java.math.BigDecimal;

public class Livro extends Produtos {
    public String escritor, editora;
    private static int id = 0;

    public Livro(int quantidade, String nome, BigDecimal preco, String genero, String escritor, String editora) {
        super(quantidade, nome, preco, genero);
        this.categoriaProduto = CategoriaDeProdutos.Livro;
        this.escritor = escritor;
        this.editora = editora;
        adicionarQuantidadeNoEstoque(quantidade);
        id += 1;
        this.idGerada = "L" + id;

    }

//    public static boolean cadastrarProduto(Livro produtoRecebido) {
//
//        for (Produtos p: produto){
//            if(p.getNome().equals(produtoRecebido.getNome()) && p.genero.equals(produtoRecebido.genero)) {
//                return false;
//            }
//        }
//        System.out.println("\t\t[CADASTRADO COM SUCESSO]");
//        Produtos.produto.add(produtoRecebido);
//        return true;
//    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
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
