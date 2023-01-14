package br.com.americanas.polotechDesafios.livraria.produtos;

import br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.*;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Produto {
    protected CategoriaDeProdutos categoriaProduto;
    protected String nome;
    protected BigDecimal preco;
    protected String genero;
    static ArrayList<Produto> addProduto = new ArrayList<>();

    public Produto(String nome, String preco) {
        this.nome = nome;
        this.preco = new BigDecimal(preco);
    }
    public Produto(String nome, String preco, String genero) {
        this.nome = nome;
        this.preco = new BigDecimal(preco);
        this.genero = genero;
    }
    public static void imprimirEstoqueGeral() {
        if (addProduto.size() == 0) {
            System.out.println("\t[Estoque vazio]");
        } else {
            for (Produto produto : addProduto) {
                System.out.println(produto);
            }
        }
    }
    public static boolean verificaSeExistiProdutoNoEstoque(){
        return addProduto.size() != 0;
    }
    public static void imprimirEstoqueDaCategoriaInformada(int opcaoDaCategoria) {

            for (Produto categoriaProduto : addProduto) {
                if (opcaoDaCategoria == 2) {
                    if (categoriaProduto instanceof Album) {
                        System.out.println(categoriaProduto);
                    } else {
                        System.out.println("\t[Categoria Album] sem estoque");
                    }
                } else if (opcaoDaCategoria == 3) {
                    if (categoriaProduto instanceof Brinquedo) {
                        System.out.println(categoriaProduto);
                    } else {
                        System.out.println("\t[Categoria Brinquedo] sem estoque");
                    }
                } else if (opcaoDaCategoria == 4) {
                    if (categoriaProduto instanceof Filme) {
                        System.out.println(categoriaProduto);
                    } else {
                        System.out.println("\t[Categoria Filme] sem estoque");
                    }
                } else if (opcaoDaCategoria == 5) {
                    if (categoriaProduto instanceof Jogo) {
                        System.out.println(categoriaProduto);
                    } else {
                        System.out.println("\t[Categoria Jogo] sem estoque");
                    }
                } else if (opcaoDaCategoria == 6) {
                    if (categoriaProduto instanceof Livro) {
                        System.out.println(categoriaProduto);
                    } else {
                        System.out.println("\t[Categoria Livro] sem estoque");
                    }
                }
        }
    }

    public static void addProdutoNoArray(Produto produto) {
        addProduto.add(produto);

    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return
                "Categoria = " + categoriaProduto +
                        "\nNome = " + nome +
                        "\nPreco = R$" + preco;
    }

}
