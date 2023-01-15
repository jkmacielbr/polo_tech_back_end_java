package br.com.americanas.polotechDesafios.livraria.produtos;

import br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.*;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Produto {
    protected CategoriaDeProdutos categoriaProduto;
    static int quantidadeEstoqueTotal, quantidadeEstoqueAlbum, quantidadeEstoqueBrinquedo,
            quantidadeEstoqueFilme, quantidadeEstoqueJogo, quantidadeEstoqueLivro;
    protected int quantidade;
    protected String nome;
    protected BigDecimal preco;
    protected String genero;
    static ArrayList<Produto> addProduto = new ArrayList<>();

    public Produto(int quantidade,String nome, String preco) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = new BigDecimal(preco);

    }

    public Produto(int quantidade, String nome, String preco, String genero) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = new BigDecimal(preco);
        this.genero = genero;

    }

    protected void adicionarQuantidadeNoEstoque(int quantidade) {
        quantidadeEstoqueTotal = quantidadeEstoqueTotal + quantidade;
        if (categoriaProduto == CategoriaDeProdutos.Album) {
            quantidadeEstoqueAlbum = quantidadeEstoqueAlbum + quantidade;
        } else if (categoriaProduto == CategoriaDeProdutos.Brinquedo) {
            quantidadeEstoqueBrinquedo = quantidadeEstoqueBrinquedo + quantidade;
        } else if (categoriaProduto == CategoriaDeProdutos.Filme) {
            quantidadeEstoqueFilme = quantidadeEstoqueFilme + quantidade;
        } else if (categoriaProduto == CategoriaDeProdutos.Jogo) {
            quantidadeEstoqueJogo = quantidadeEstoqueJogo + quantidade;
        } else if (categoriaProduto == CategoriaDeProdutos.Livro) {
            quantidadeEstoqueLivro = quantidadeEstoqueLivro + quantidade;
        }
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

    public static boolean verificaSeExistiProdutoNoEstoque() {
        return addProduto.size() != 0;
    }

    public static void imprimirEstoqueDaCategoriaInformada(int opcaoDaCategoria) {

        for (Produto categoriaProduto : addProduto) {
            if (opcaoDaCategoria == 1 && quantidadeEstoqueAlbum > 0) {
                if (categoriaProduto instanceof Album) {
                    System.out.println(categoriaProduto);
                }
            }
            else if (opcaoDaCategoria == 2 && quantidadeEstoqueBrinquedo > 0) {
                if (categoriaProduto instanceof Brinquedo) {
                    System.out.println(categoriaProduto);
                }
            } else if (opcaoDaCategoria == 3 && quantidadeEstoqueFilme > 0) {
                if (categoriaProduto instanceof Filme) {
                    System.out.println(categoriaProduto);
                }
            } else if (opcaoDaCategoria == 4 && quantidadeEstoqueJogo > 0) {
                if (categoriaProduto instanceof Jogo) {
                    System.out.println(categoriaProduto);
                }
            } else if (opcaoDaCategoria == 5 && quantidadeEstoqueLivro > 0) {
                if (categoriaProduto instanceof Livro) {
                    System.out.println(categoriaProduto);
                }
            } else {
                System.out.println("\t\t\t[CATEGORIA SELECIONADA COM ESTOQUE VAZIO]");
            }
        }
    }

    public static void addProdutoNoArray(Produto produto) {
        addProduto.add(produto);

    }

    public String getNome() {
        return nome;
    }

    public static int getQuantidadeEstoqueTotal() {
        return quantidadeEstoqueTotal;
    }

    public static int getQuantidadeEstoqueAlbum() {
        return quantidadeEstoqueAlbum;
    }

    public static int getQuantidadeEstoqueBrinquedo() {
        return quantidadeEstoqueBrinquedo;
    }

    public static int getQuantidadeEstoqueFilme() {
        return quantidadeEstoqueFilme;
    }

    public static int getQuantidadeEstoqueJogo() {
        return quantidadeEstoqueJogo;
    }

    public static int getQuantidadeEstoqueLivro() {
        return quantidadeEstoqueLivro;
    }

    @Override
    public String toString() {
        return
                "Categoria = " + categoriaProduto +
                        "\nQuantidade = "+ quantidade +
                        "\nNome = " + nome +
                        "\nPreco = R$" + preco;
    }

}
