package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;


public class Funcionalidades {
    public static int quantidade = 0;
    public static String nome, genero;
    public static BigDecimal preco;
    static public String escritor, editora; //LIVROS
    static public String distribuidora, estudioJogos; //JOGOS
    static public String estudioFilmes, diretores, produtores; //FILMES
    public static String musicasOuBandas, selos; //ALBUM MÚSICAS
    public static String tipo; //BRINQUEDOS
    static Scanner tc = new Scanner(System.in);

    public static boolean isTemProdutoNoEsotque() {
        return Produtos.produto.size() != 0;
    }

    public static void cadastrarProduto(int op) {
        if (op == 1) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosAlbum();
            Produtos produtoAlbum = new Album(quantidade, nome, preco, genero, musicasOuBandas, selos);
            Produtos.produto.add(produtoAlbum);
        } else if (op == 2) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosBrinquedo();
            Produtos produtoBrinquedo = new Brinquedo(quantidade, nome, preco, tipo);
            Produtos.produto.add(produtoBrinquedo);
        } else if (op == 3) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosFilme();
            Produtos produtoFilme = new Filme(quantidade, nome, preco, genero, estudioFilmes, diretores, produtores);
            Produtos.produto.add(produtoFilme);
        } else if (op == 4) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosjogo();
            Produtos produtoJogo = new Jogo(quantidade, nome, preco, genero, distribuidora, estudioJogos);
            Produtos.produto.add(produtoJogo);
        } else if (op == 5) {
            RecebeDadosDeCadastro.receberDadosGeral(op);
            RecebeDadosDeCadastro.receberDadosLivro();
            Produtos produtoLivro = new Livro(quantidade, nome, preco, genero, escritor, editora);
            Produtos.produto.add(produtoLivro);

        } else {
            System.out.println("OpcaoInválida");

        }

        System.out.println("\t\t[CADASTRADO COM SUCESSO]");


    }

    public static void mostraTodoEstoque() {
        if (isTemProdutoNoEsotque()) {
            for (Produtos produtos : Produtos.produto) {
                System.out.println(produtos);
            }
        } else {

                System.out.println("\t[Estoque vazio]");


        }
    }

    public static int quantidadeEstoqueTotal(){
        return Album.quantidadeEstoqueAlbum + Brinquedo.quantidadeEstoqueBrinquedo + Filme.quantidadeEstoqueFilme
                + Jogo.quantidadeEstoqueJogo + Livro.quantidadeEstoqueLivro;
    }

    public static void mostraEstoquePorCategoria(int opcaoDaCategoria) {

        for (Produtos produto : Produtos.produto) {
            if (opcaoDaCategoria == 1 && Album.quantidadeEstoqueAlbum > 0 || Album.quantidadeEstoqueAlbum == 0 && produto != null) {
                if (produto instanceof Album) {
                    System.out.println(produto + "\n");
                }
            } else if (opcaoDaCategoria == 2 && Brinquedo.quantidadeEstoqueBrinquedo > 0 || Brinquedo.quantidadeEstoqueBrinquedo == 0 && produto != null) {
                if (produto instanceof Brinquedo) {
                    System.out.println(produto + "\n");
                }
            } else if (opcaoDaCategoria == 3 && Filme.quantidadeEstoqueFilme > 0 || Filme.quantidadeEstoqueFilme == 0 && produto != null) {
                if (produto instanceof Filme) {
                    System.out.println(produto + "\n");
                }
            } else if (opcaoDaCategoria == 4 && Jogo.quantidadeEstoqueJogo > 0 || Jogo.quantidadeEstoqueJogo == 0 && produto != null) {
                if (produto instanceof Jogo) {
                    System.out.println(produto + "\n");
                }
            } else if (opcaoDaCategoria == 5 && Livro.quantidadeEstoqueLivro > 0 || Livro.quantidadeEstoqueLivro == 0 && produto != null) {
                if (produto instanceof Livro) {
                    System.out.println(produto + "\n");
                }
            } else if (opcaoDaCategoria == 10 && produto.quantidade == 0) {
                System.out.println(produto + "\n");
            }
        }
    }

    public static void adicionarQuantidadeNoEstoque(int quantidade, CategoriaDeProdutos categoriaProduto) {
        if (validaQuantidade(quantidade)) {

            if (categoriaProduto == CategoriaDeProdutos.Album) {
                Album.quantidadeEstoqueAlbum = Album.quantidadeEstoqueAlbum + quantidade;
            } else if (categoriaProduto == CategoriaDeProdutos.Brinquedo) {
                Brinquedo.quantidadeEstoqueBrinquedo = Brinquedo.quantidadeEstoqueBrinquedo + quantidade;
            } else if (categoriaProduto == CategoriaDeProdutos.Filme) {
                Filme.quantidadeEstoqueFilme = Filme.quantidadeEstoqueFilme + quantidade;
            } else if (categoriaProduto == CategoriaDeProdutos.Jogo) {
                Jogo.quantidadeEstoqueJogo = Jogo.quantidadeEstoqueJogo + quantidade;
            } else if (categoriaProduto == CategoriaDeProdutos.Livro) {
                Livro.quantidadeEstoqueLivro = Livro.quantidadeEstoqueLivro + quantidade;
            }
        }
    }

    public static boolean removeQuantidadeNoEstoqueDoProduto(String idInformada, int quantidade) {
        String idUppercase;
        idUppercase = idInformada.toUpperCase();
        if (validaQuantidade(quantidade)) {
            for (Produtos p : Produtos.produto) {

                if (quantidade > p.quantidade && p.idGerada.equals(idUppercase)) {
                    System.out.println("\n\t\t\t\t[QUANTIDADE NÃO DISPONIVEL EM ESTOQUE]\n[Nome do produto: " + p.getNome() +
                            "]\t [Categoria: " + p.categoriaProduto + "]\t Quantidade no estoque: " + p.quantidade + "\n");
                    return false;
                }
                if (p.getIdgerada().equals(idUppercase) && quantidade <= p.quantidade) {
                    p.dataDeCadastro = FormataData.geraDataDeCadastro(new Date());

                    p.quantidade -= quantidade;

                    if (p instanceof Album) {
                        Album.quantidadeEstoqueAlbum -= quantidade;

                    } else if (p instanceof Brinquedo) {
                        Brinquedo.quantidadeEstoqueBrinquedo -= quantidade;
//

                    } else if (p instanceof Filme) {
                       Filme.quantidadeEstoqueFilme -= quantidade;
//

                    } else if (p instanceof Jogo) {
                        Jogo.quantidadeEstoqueJogo -= quantidade;
//

                    } else if (p instanceof Livro) {
                        Livro.quantidadeEstoqueLivro -= quantidade;
//
                    }
                    System.out.println("\n\t\t\t\t[QUANTIDADE REMOVIDA DO ESTOQUE ]\n[Nome do produto: " + p.getNome() +
                            "]\t [Categoria: " + p.categoriaProduto + "]\t Quantidade no estoque: " + p.quantidade + "\n");
                    return true;
                }
            }
        }
        return false;

    }

    public static Produtos buscarProdutoPelaID(String idInformada) {
        String idUppercase;
        idUppercase = idInformada.toUpperCase();
        for (Produtos produto : Produtos.produto) {
            if (produto.getIdgerada().equals(idUppercase)) {
                return produto;
            }
        }
        return null;
    }


    public static void alterarProdutoCadastrado(int respostaUsuario, Produtos produto) {
        int quantidade;

        if (produto instanceof Brinquedo) {
            switch (respostaUsuario) {
                case 1 -> {
                    System.out.print("Novo Nome: ");

                    produto.setNome(tc.nextLine());


                }
                case 2 -> {
                    System.out.print("Novo Preço: ");
                    produto.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));

                }

                case 3 -> {
                    System.out.print("Adicionar quantidade: ");
                    quantidade = ValidacaoDeInputs.inputIsvalido();
                    if (validaQuantidade(quantidade)) {
                        Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produto.categoriaProduto);
                        produto.quantidade += quantidade;
                    }

                }
                case 4 -> {
                    System.out.print("Novo tipo: ");
                    ((Brinquedo) produto).setTipo(tc.nextLine());
                }
                default -> System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");
            }

            produto.dataDeCadastro = FormataData.geraDataDeCadastro(new Date());

        } else if (produto instanceof Album) {

            switch (respostaUsuario) {
                case 1 -> {
                    System.out.print("Novo Nome: ");
                    produto.setNome(tc.nextLine());
                }
                case 2 -> {
                    System.out.print("Novo Preço: ");
                    produto.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));
                }
                case 3 -> {
                    System.out.print("Adicionar quantidade: ");
                    quantidade = ValidacaoDeInputs.inputIsvalido();
                    if (validaQuantidade(quantidade)) {
                        Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produto.categoriaProduto);
                        produto.quantidade += quantidade;
                    }
                }
                case 4 -> {
                    System.out.print("Novo Genêro: ");
                    ((Album) produto).setGenero(tc.nextLine());
                }
                case 5 -> {
                    System.out.print("Nova Música ou Banda: ");
                    ((Album) produto).setMusicaOuBanda(tc.nextLine());
                }
                case 6 -> {
                    System.out.print("Novo Selo: ");
                    ((Album) produto).setSelos(tc.nextLine());
                }
                default -> System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");
            }
            produto.dataDeCadastro = FormataData.geraDataDeCadastro(new Date());

        } else if (produto instanceof Filme) {

            switch (respostaUsuario) {
                case 1 -> {
                    System.out.print("Novo Nome: ");
                    produto.setNome(tc.nextLine());
                }
                case 2 -> {
                    System.out.print("Novo Preço: ");
                    produto.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));
                }
                case 3 -> {
                    System.out.print("Adicionar quantidade: ");
                    quantidade = ValidacaoDeInputs.inputIsvalido();
                    if (validaQuantidade(quantidade)) {
                        Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produto.categoriaProduto);
                        produto.quantidade += quantidade;
                    }
                }
                case 4 -> {
                    System.out.print("Novo Genêro: ");
                    ((Filme) produto).setGenero(tc.nextLine());
                }
                case 5 -> {
                    System.out.print("Novo Estúdio: ");
                    ((Filme) produto).setEstudio(tc.nextLine());
                }
                case 6 -> {
                    System.out.print("Novo Diretor: ");
                    ((Filme) produto).setDiretores(tc.nextLine());
                }
                case 7 -> {
                    System.out.print("Novo Produtor: ");
                    ((Filme) produto).setProdutores(tc.nextLine());
                }
                default -> System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");
            }
            produto.dataDeCadastro = FormataData.geraDataDeCadastro(new Date());
        } else if (produto instanceof Jogo) {

            switch (respostaUsuario) {
                case 1 -> {
                    System.out.print("Novo Nome: ");
                    produto.setNome(tc.nextLine());
                }
                case 2 -> {
                    System.out.print("Novo Preço: ");
                    produto.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));
                }
                case 3 -> {
                    System.out.print("Adicionar quantidade: ");

                    quantidade = ValidacaoDeInputs.inputIsvalido();
                    if (validaQuantidade(quantidade)) {
                        Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produto.categoriaProduto);
                        produto.quantidade += quantidade;
                    }
                }
                case 4 -> {
                    System.out.print("Novo Genêro: ");
                    ((Jogo) produto).setGenero(tc.nextLine());
                }
                case 5 -> {
                    System.out.print("Nova Distribuidora: ");
                    ((Jogo) produto).setDistribuidora(tc.nextLine());
                }
                case 6 -> {
                    System.out.print("Novo Estúdio: ");
                    ((Jogo) produto).setEstudio(tc.nextLine());
                }
                default -> System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");

            }
            produto.dataDeCadastro = FormataData.geraDataDeCadastro(new Date());
        } else if (produto instanceof Livro) {

            switch (respostaUsuario) {
                case 1 -> {
                    System.out.print("Novo Nome: ");
                    produto.setNome(tc.nextLine());
                }
                case 2 -> {
                    System.out.print("Novo Preço: ");
                    produto.setPreco(BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido()));
                }
                case 3 -> {
                    System.out.print("Adicionar quantidade: ");
                    quantidade = ValidacaoDeInputs.inputIsvalido();
                    if (validaQuantidade(quantidade)) {
                        Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produto.categoriaProduto);
                        produto.quantidade += quantidade;
                    }
                }
                case 4 -> {
                    System.out.print("Novo Genêro: ");
                    ((Livro) produto).setGenero(tc.nextLine());
                }
                case 5 -> {
                    System.out.print("Novo Escritor: ");
                    ((Livro) produto).setEscritor(tc.nextLine());
                }
                case 6 -> {
                    System.out.print("Nova Editora: ");
                    ((Livro) produto).setEditora(tc.nextLine());
                }
                default -> System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t[OPÇÃO INVÁLIDA]");

            }
            produto.dataDeCadastro = FormataData.geraDataDeCadastro(new Date());
        }

    }


    public static boolean validaQuantidade(int quantidade) {
        if (quantidade > 0) {
            return true;
        } else System.out.println("\t\t\n[INFORMAR QUANTIDADE MAIOR QUE 0]\n");
        return false;

    }

    public static void realizarVenda(Produtos produto, int quantidadeVender) {
        if (validaQuantidade(quantidadeVender)) {
            if (removeQuantidadeNoEstoqueDoProduto(produto.idGerada, quantidadeVender)) {
                Produtos.valorDeVendas = Produtos.valorDeVendas.add(produto.preco.multiply(new BigDecimal(quantidadeVender)));
            } else System.out.println("\t\t[VENDA NÃO REALIZADA]\n");

        }
    }


}
