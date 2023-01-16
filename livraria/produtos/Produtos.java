package br.com.americanas.polotechDesafios.livraria.produtos;

import br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.*;
import br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.Utilitario.GerarData;
import br.com.americanas.polotechDesafios.livraria.produtos.enumProdutos.CategoriaDeProdutos;


import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Produtos {

    protected static int id = 0;
    static int quantidadeEstoqueTotal, quantidadeEstoqueAlbum, quantidadeEstoqueBrinquedo,
            quantidadeEstoqueFilme, quantidadeEstoqueJogo, quantidadeEstoqueLivro;
    protected int quantidade;
    public String nome;
    protected String idGerada;
    protected BigDecimal preco;
    protected CategoriaDeProdutos categoriaProduto;
    public String genero;
    protected String dataDeCadastro;
    protected DecimalFormat formatarPreco = new DecimalFormat("0.00");
    public static ArrayList<Produtos> produto = new ArrayList<>();


    public Produtos(int quantidade, String nome, BigDecimal preco) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.dataDeCadastro = GerarData.geraDataDeCadastro(new Date());

    }

    public Produtos(int quantidade, String nome, BigDecimal preco, String genero) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.dataDeCadastro = GerarData.geraDataDeCadastro(new Date());
        this.genero = genero;


    }

    public static boolean cadastrarProduto(Produtos produtoRecebido) {
        for (Produtos p: produto){
            if(produtoRecebido instanceof Brinquedo){
                if(p.getNome().equals(produtoRecebido.getNome())) {
                    System.out.println("\t\t[PRODUTO JÁ EXISTE NO SISTEMA]");
                    return false;
                }

            }
            else if(p.getNome().equals(produtoRecebido.getNome()) && p.genero.equals(produtoRecebido.genero)) {
                System.out.println("\t\t[PRODUTO JÁ EXISTE NO SISTEMA]");
                return false;
            }
        }
        System.out.println("\t\t[CADASTRADO COM SUCESSO]");
        Produtos.produto.add(produtoRecebido);
        return true;
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

    public static void mostraTodoEstoque() {
        if (produto.size() == 0) {
            System.out.println("\t[Estoque vazio]");
        } else {
            for (Produtos produtos : produto) {
                System.out.println(produtos);
            }

        }
    }

    public static Produtos buscarProdutoPelaID(String idInformada) {
        String idUppercase;
        for (Produtos produto : produto) {
            idUppercase = idInformada.toUpperCase();
            if (produto.getIdgerada().equals(idUppercase)) {
                return produto;
            } else return null;

        }
        return null;
    }

    public static boolean isTemProdutoNoEsotque() {
        return produto.size() != 0;
    }

    public static void mostraEstoquePorCategoria(int opcaoDaCategoria) {

        for (Produtos categoriaProdutos : produto) {
            if (opcaoDaCategoria == 1 && quantidadeEstoqueAlbum > 0) {
                if (categoriaProdutos instanceof Album) {
                    System.out.println(categoriaProdutos);
                }
            } else if (opcaoDaCategoria == 2 && quantidadeEstoqueBrinquedo > 0) {
                if (categoriaProdutos instanceof Brinquedo) {
                    System.out.println(categoriaProdutos);
                }
            } else if (opcaoDaCategoria == 3 && quantidadeEstoqueFilme > 0) {
                if (categoriaProdutos instanceof Filme) {
                    System.out.println(categoriaProdutos);
                }
            } else if (opcaoDaCategoria == 4 && quantidadeEstoqueJogo > 0) {
                if (categoriaProdutos instanceof Jogo) {
                    System.out.println(categoriaProdutos);
                }
            } else if (opcaoDaCategoria == 5 && quantidadeEstoqueLivro > 0) {
                if (categoriaProdutos instanceof Livro) {
                    System.out.println(categoriaProdutos);
                }
            } else {
                System.out.println("\t\t\t[CATEGORIA SELECIONADA COM ESTOQUE VAZIO]");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public String getIdgerada() {
        return idGerada;
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
                "\t\t\t\t\tCategoria = " + categoriaProduto +
                        "\t\t\tQuantidade = " + quantidade +
                        "\t\t\tData de Cadastro = " + dataDeCadastro +
                        "\nNome = " + nome +
                        "\t\t\tPreço = R$" + formatarPreco.format(preco) +
                        "\n\t\t\t\t\t\t\t\t\t\t[Mais Informações]";

    }

}
