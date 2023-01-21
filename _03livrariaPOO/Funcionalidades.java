package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.GeradorDeData;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.RecebeDadosDeCadastro;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.ValidacaoDeInputs;
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
        if (Produtos.produto.size() == 0) {
            System.out.println("\t[Estoque vazio]");
        } else {
            for (Produtos produtos : Produtos.produto) {
                System.out.println(produtos);
            }

        }
    }

    public static void mostraEstoquePorCategoria(int opcaoDaCategoria) {

        for (Produtos categoriaProdutos : Produtos.produto) {
            if (opcaoDaCategoria == 1 && Produtos.quantidadeEstoqueAlbum > 0 || Produtos.quantidadeEstoqueAlbum == 0 && categoriaProdutos != null) {
                if (categoriaProdutos instanceof Album) {
                    System.out.println(categoriaProdutos);
                }
            } else if (opcaoDaCategoria == 2 && Produtos.quantidadeEstoqueBrinquedo > 0 || Produtos.quantidadeEstoqueBrinquedo == 0 && categoriaProdutos != null) {
                if (categoriaProdutos instanceof Brinquedo) {
                    System.out.println(categoriaProdutos);
                }
            } else if (opcaoDaCategoria == 3 && Produtos.quantidadeEstoqueFilme > 0 || Produtos.quantidadeEstoqueFilme == 0 && categoriaProdutos != null) {
                if (categoriaProdutos instanceof Filme) {
                    System.out.println(categoriaProdutos);
                }
            } else if (opcaoDaCategoria == 4 && Produtos.quantidadeEstoqueJogo > 0 || Produtos.quantidadeEstoqueJogo == 0 && categoriaProdutos != null) {
                if (categoriaProdutos instanceof Jogo) {
                    System.out.println(categoriaProdutos);
                }
            } else if (opcaoDaCategoria == 5 && Produtos.quantidadeEstoqueLivro > 0 || Produtos.quantidadeEstoqueLivro == 0 && categoriaProdutos != null) {
                if (categoriaProdutos instanceof Livro) {
                    System.out.println(categoriaProdutos);
                }
            } else if (opcaoDaCategoria == 10 && categoriaProdutos.quantidade == 0){
                System.out.println(categoriaProdutos);
            }
        }



    }

    public static void adicionarQuantidadeNoEstoque(int quantidade, CategoriaDeProdutos categoriaProduto) {
        if (validaQuantidade(quantidade)) {
            Produtos.quantidadeEstoqueTotal = Produtos.quantidadeEstoqueTotal + quantidade;
            if (categoriaProduto == CategoriaDeProdutos.Album) {
                Produtos.quantidadeEstoqueAlbum = Produtos.quantidadeEstoqueAlbum + quantidade;
            } else if (categoriaProduto == CategoriaDeProdutos.Brinquedo) {
                Produtos.quantidadeEstoqueBrinquedo = Produtos.quantidadeEstoqueBrinquedo + quantidade;
            } else if (categoriaProduto == CategoriaDeProdutos.Filme) {
                Produtos.quantidadeEstoqueFilme = Produtos.quantidadeEstoqueFilme + quantidade;
            } else if (categoriaProduto == CategoriaDeProdutos.Jogo) {
                Produtos.quantidadeEstoqueJogo = Produtos.quantidadeEstoqueJogo + quantidade;
            } else if (categoriaProduto == CategoriaDeProdutos.Livro) {
                Produtos.quantidadeEstoqueLivro = Produtos.quantidadeEstoqueLivro + quantidade;
            }
        }
    }

    public static boolean removeQuantidadeNoEstoqueDoProduto(String idInformada, int quantidade) {
        String idUppercase;
        idUppercase = idInformada.toUpperCase();
        if (validaQuantidade(quantidade)) {
            for (Produtos p : Produtos.produto) {

                if (quantidade > Produtos.quantidadeEstoqueTotal || quantidade > p.quantidade && p.idGerada.equals(idUppercase)) {
                    System.out.println("\n\t\t\t\t[QUANTIDADE NÃO DISPONIVEL EM ESTOQUE]\n[Nome do produto: " + p.getNome() +
                            "]\t [Categoria: " + p.categoriaProduto + "]\t Quantidade no estoque: " + p.quantidade + "\n");
                    return false;
                }
                if (p.getIdgerada().equals(idUppercase) && Produtos.quantidadeEstoqueTotal >= quantidade && quantidade <= p.quantidade) {
                    p.dataDeCadastro = GeradorDeData.geraDataDeCadastro(new Date());
                    Produtos.quantidadeEstoqueTotal -= quantidade;
                    p.quantidade -= quantidade;

                    if (p instanceof Album) {
                        Produtos.quantidadeEstoqueAlbum -= quantidade;

                    } else if (p instanceof Brinquedo) {
                        Produtos.quantidadeEstoqueBrinquedo -= quantidade;
//

                    } else if (p instanceof Filme) {
                        Produtos.quantidadeEstoqueFilme -= quantidade;
//

                    } else if (p instanceof Jogo) {
                        Produtos.quantidadeEstoqueJogo -= quantidade;
//

                    } else if (p instanceof Livro) {
                        Produtos.quantidadeEstoqueLivro -= quantidade;
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
                if (validaQuantidade(quantidade)) {
                    Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produtoCadastrado.categoriaProduto);
                    produtoCadastrado.quantidade += quantidade;
                }


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
                if (validaQuantidade(quantidade)) {
                    Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produtoCadastrado.categoriaProduto);
                    produtoCadastrado.quantidade += quantidade;
                }

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
                if (validaQuantidade(quantidade)) {
                    Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produtoCadastrado.categoriaProduto);
                    produtoCadastrado.quantidade += quantidade;
                }

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
                if (validaQuantidade(quantidade)) {
                    Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produtoCadastrado.categoriaProduto);
                    produtoCadastrado.quantidade += quantidade;
                }

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
                if (validaQuantidade(quantidade)) {
                    Funcionalidades.adicionarQuantidadeNoEstoque(quantidade, produtoCadastrado.categoriaProduto);
                    produtoCadastrado.quantidade += quantidade;
                }

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

    public static boolean validaQuantidade(int quantidade) {
        if (quantidade > 0) {
            return true;
        } else System.out.println("\t[INFORMAR QUANTIDADE MAIOR QUE 0]");
        return false;

    }


    public static void realizarVenda(Produtos produto, int quantidadeVender) {
        if (validaQuantidade(quantidadeVender)) {
            if (removeQuantidadeNoEstoqueDoProduto(produto.idGerada, quantidadeVender)) {
                Produtos.valorDeVendas = Produtos.valorDeVendas.add(produto.preco.multiply(new BigDecimal(quantidadeVender)));
            } else System.out.println("Venda não realizada");

        }
    }


}
