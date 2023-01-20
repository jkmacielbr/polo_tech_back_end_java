package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos;


import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.GeradorDeData;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.ValidacaoDeInputs;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos.*;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class Produtos {

    protected static int id = 0;
    public static int quantidadeEstoqueTotal, quantidadeEstoqueAlbum, quantidadeEstoqueBrinquedo,
            quantidadeEstoqueFilme, quantidadeEstoqueJogo, quantidadeEstoqueLivro;
    public static int quantidade;
    public String nome;
    protected String idGerada;
    public BigDecimal preco;
    protected CategoriaDeProdutos categoriaProduto;
    public String genero;
    protected String dataDeCadastro;
    protected static BigDecimal valorDeVendas = new BigDecimal("0.00");
    protected DecimalFormat formatarPreco = new DecimalFormat("0.00");
    public static ArrayList<Produtos> produto = new ArrayList<>();

    public Produtos(int quantidade, String nome, BigDecimal preco) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());
    }

    public Produtos(int quantidade, String nome, BigDecimal preco, String genero) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());
        this.genero = genero;

    }

    public static void alterarProdutoCadastrado(Produtos produtoCadastrado) {
        int resposta;
        int quantidade;
        Scanner tc = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t[ESOLHA QUAL INFORMAÇÃO DESEJA ALTERAR]");

        System.out.print("\t[1]NOME\t\t\t\t [2]PREÇO\t\t\t\t [3]QUANTIDADE\t\t\t\t");
        if (produtoCadastrado instanceof Brinquedo) {
            System.out.println(" [4]TIPO");
            resposta = ValidacaoDeInputs.inputIsvalido();
            if (resposta > 4) {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");

            } else if (resposta == 1) {
                System.out.print("Novo Nome: ");
                produtoCadastrado.setNome(tc.nextLine());

            } else if (resposta == 2) {
                System.out.print("Novo Preço: ");
                produtoCadastrado.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));

            } else if (resposta == 3) {
                System.out.print("Adicionar quantidade: ");
                quantidade = ValidacaoDeInputs.inputIsvalido();
                produtoCadastrado.adicionarQuantidadeNoEstoque(quantidade);
                produtoCadastrado.quantidade += quantidade;

            } else if (resposta == 4) {
                System.out.print("Novo tipo: ");
                ((Brinquedo) produtoCadastrado).setTipo(tc.nextLine());

            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");
            }
            produtoCadastrado.dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());

        } else {
            System.out.println(" [4]GENÊRO \t\t");
        }

        if (produtoCadastrado instanceof Album) {
            System.out.println(" [5]MÚSICAS OU BANDAS\t\t [6]SELOS \t");

            resposta = ValidacaoDeInputs.inputIsvalido();
            if (resposta == 1) {
                System.out.print("Novo Nome: ");
                produtoCadastrado.setNome(tc.nextLine());
            } else if (resposta == 2) {
                System.out.print("Novo Preço: ");
                produtoCadastrado.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));
            } else if (resposta == 3) {
                System.out.print("Adicionar quantidade: ");
                quantidade = ValidacaoDeInputs.inputIsvalido();
                produtoCadastrado.adicionarQuantidadeNoEstoque(quantidade);
                produtoCadastrado.quantidade += quantidade;

            } else if (resposta == 4) {
                System.out.print("Novo Genêro: ");
                produtoCadastrado.setGenero(tc.nextLine());
            } else if (resposta == 5) {
                System.out.print("Nova Música ou Banda: ");
                ((Album) produtoCadastrado).setMusicaOuBanda(tc.nextLine());
            } else if (resposta == 6) {
                System.out.print("Novo Selo: ");
                ((Album) produtoCadastrado).setSelos(tc.nextLine());
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");
            }
            produtoCadastrado.dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());
        } else if (produtoCadastrado instanceof Filme) {
            System.out.println(" [5]ESTÚDIOS\t\t [6]DIRETORIES\t\t [7]PRODUTORES\t\t [8]PRODUTORES");
            resposta = ValidacaoDeInputs.inputIsvalido();
            if (resposta == 1) {
                System.out.print("Novo Nome: ");
                produtoCadastrado.setNome(tc.nextLine());
            } else if (resposta == 2) {
                System.out.print("Novo Preço: ");
                produtoCadastrado.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));
            } else if (resposta == 3) {
                System.out.print("Adicionar quantidade: ");
                quantidade = ValidacaoDeInputs.inputIsvalido();
                produtoCadastrado.adicionarQuantidadeNoEstoque(quantidade);
                produtoCadastrado.quantidade += quantidade;

            } else if (resposta == 4) {
                System.out.print("Novo Genêro: ");
                produtoCadastrado.setGenero(tc.nextLine());
            } else if (resposta == 5) {
                System.out.print("Novo Estúdio: ");
                ((Filme) produtoCadastrado).setEstudio(tc.nextLine());
            } else if (resposta == 6) {
                System.out.print("Novo Diretor: ");
                ((Filme) produtoCadastrado).setDiretores(tc.nextLine());
            } else if (resposta == 7) {
                System.out.print("Novo Produtor: ");
                ((Filme) produtoCadastrado).setProdutores(tc.nextLine());
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");
            }
            produtoCadastrado.dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());

        } else if (produtoCadastrado instanceof Jogo) {
            System.out.println(" [5]DISTRIBUIDORA\t\t [6]ESTÚDIO");
            resposta = ValidacaoDeInputs.inputIsvalido();
            if (resposta == 1) {
                System.out.print("Novo Nome: ");
                produtoCadastrado.setNome(tc.nextLine());
            } else if (resposta == 2) {
                System.out.print("Novo Preço: ");
                produtoCadastrado.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));
            } else if (resposta == 3) {
                System.out.print("Adicionar quantidade: ");

                quantidade = ValidacaoDeInputs.inputIsvalido();
                produtoCadastrado.adicionarQuantidadeNoEstoque(quantidade);
                produtoCadastrado.quantidade += quantidade;

            } else if (resposta == 4) {
                System.out.print("Novo Genêro: ");
                produtoCadastrado.setGenero(tc.nextLine());
            } else if (resposta == 5) {
                System.out.print("Nova Distribuidora: ");
                ((Jogo) produtoCadastrado).setDistribuidora(tc.nextLine());
            } else if (resposta == 6) {
                System.out.print("Novo Estúdio: ");
                ((Jogo) produtoCadastrado).setEstudio(tc.nextLine());
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");
            }
            produtoCadastrado.dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());

        } else if (produtoCadastrado instanceof Livro) {
            System.out.println(" [5]ESCRITOR\t\t [6]EDITORA");
            resposta = ValidacaoDeInputs.inputIsvalido();
            if (resposta == 1) {
                System.out.print("Novo Nome: ");
                produtoCadastrado.setNome(tc.nextLine());
            } else if (resposta == 2) {
                System.out.print("Novo Preço: ");
                produtoCadastrado.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));
            } else if (resposta == 3) {
                System.out.print("Adicionar quantidade: ");
                quantidade = ValidacaoDeInputs.inputIsvalido();
                produtoCadastrado.adicionarQuantidadeNoEstoque(quantidade);
                produtoCadastrado.quantidade += quantidade;

            } else if (resposta == 4) {
                System.out.print("Novo Genêro: ");
                produtoCadastrado.setGenero(tc.nextLine());
            } else if (resposta == 5) {
                System.out.print("Novo Escritor: ");
                ((Livro) produtoCadastrado).setEscritor(tc.nextLine());
            } else if (resposta == 6) {
                System.out.print("Nova Editora: ");
                ((Livro) produtoCadastrado).setEditora(tc.nextLine());
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");
            }
            produtoCadastrado.dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());
        }

    }

    public static boolean removeQuantidadeNoEstoqueDoProduto(String idInformada, int quantidade) {
        String idUppercase;
        idUppercase = idInformada.toUpperCase();
        for (Produtos p : produto) {

            if (quantidade > quantidadeEstoqueTotal || quantidade > p.quantidade && p.idGerada.equals(idUppercase)) {
                System.out.println("\n\t\t\t\t[QUANTIDADE NÃO DISPONIVEL EM ESTOQUE]\n[Nome do produto: " + p.getNome() +
                        "]\t [Categoria: " + p.categoriaProduto + "]\t Quantidade no estoque: " + p.quantidade + "\n");
                return false;
            }
            if (p.getIdgerada().equals(idUppercase) && quantidadeEstoqueTotal >= quantidade && quantidade <= p.quantidade) {
                p.dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());
                quantidadeEstoqueTotal -= quantidade;
                p.quantidade -= quantidade;

                if (p instanceof Album) {
                    quantidadeEstoqueAlbum -= quantidade;

                } else if (p instanceof Brinquedo) {
                    quantidadeEstoqueBrinquedo -= quantidade;
//

                } else if (p instanceof Filme) {
                    quantidadeEstoqueFilme -= quantidade;
//

                } else if (p instanceof Jogo) {
                    quantidadeEstoqueJogo -= quantidade;
//

                } else if (p instanceof Livro) {
                    quantidadeEstoqueLivro -= quantidade;
//
                }
                System.out.println("\n\t\t\t\t[QUANTIDADE REMOVIDA DO ESTOQUE ]\n[Nome do produto: " + p.getNome() +
                        "]\t [Categoria: " + p.categoriaProduto + "]\t Quantidade no estoque: " + p.quantidade + "\n");
                return true;
            }


        }
        return false;
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
            }

        }
        System.out.println("\t\t\t[CATEGORIA SELECIONADA COM ESTOQUE VAZIO]");

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

    public static Produtos buscarProdutoPelaID(String idInformada) {
        String idUppercase;
        idUppercase = idInformada.toUpperCase();
        for (Produtos produto : produto) {
            if (produto.getIdgerada().equals(idUppercase)) {
                return produto;
            }

        }
        return null;
    }


    public static boolean isTemProdutoNoEsotque() {
        return produto.size() != 0;
    }

    public static void realizarVenda(Produtos produto, int quantidadeVender) {
        if(removeQuantidadeNoEstoqueDoProduto(produto.idGerada, quantidadeVender)) {
            valorDeVendas = valorDeVendas.add(produto.preco.multiply(new BigDecimal(quantidadeVender)));
        } else System.out.println("Venda não realizada");

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public static BigDecimal getValorDeVendas() {
        return valorDeVendas;
    }

    @Override
    public String toString() {
        return
                "\t\t\t\t\tCategoria = " + categoriaProduto +
                        "\t\t\tQuantidade = " + quantidade +
                        "\t\t\tÚltima atualização = " + dataDeCadastro +
                        "\nNome = " + nome +
                        "\t\t\tPreço = R$" + formatarPreco.format(preco) +
                        "\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t[Mais Informações]";

    }

}
