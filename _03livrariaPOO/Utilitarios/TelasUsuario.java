package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos.*;

import java.util.Scanner;

public class TelasUsuario {
    Scanner tc = new Scanner(System.in);
    int respostaUsuario;

    public void telaMenuInicial() {


        do {
            System.out.println("[1] CADASTRAR PRODUTO");
            System.out.println("[2] CAIXA");
            System.out.println("[3] ESTOQUE [VER | ALTERAR | REMOVER]");
            System.out.println("[0] SAIR");
            respostaUsuario = ValidacaoDeInputs.inputIsvalido();
            if (respostaUsuario != 5) {

                if (respostaUsuario == 1) {
                    telaDeCadastro();
                } else if (respostaUsuario == 2) {
                    if (Funcionalidades.isTemProdutoNoEsotque()) {
                        telaCaixa();
                    } else System.out.println("\t[OBRIGATÓRIO CADASTRAR AO MENOS 1 PRODUTO]");
                } else if (respostaUsuario == 3) {
                    if (Funcionalidades.isTemProdutoNoEsotque()) telaDeEstoque();
                    else System.out.println("\t[OBRIGATÓRIO CADASTRAR AO MENOS 1 PRODUTO NO ESTOQUE]");
                } else if (respostaUsuario != 0) {
                    System.out.println("\t\t\t[OPÇÃO INVÁLIDA]");

                }
            }

        } while (respostaUsuario != 0);

    }

    private void telaDeCadastro() {


        do {
            System.out.println("\t\t[CADASTRAR PRODUTOS]");
            System.out.println("[1] ALBUM DE MÚSICA");
            System.out.println("[2] BRINQUEDO");
            System.out.println("[3] FILME");
            System.out.println("[4] JOGO");
            System.out.println("[5] LIVRO");
            System.out.println("[0] SAIR");
            respostaUsuario = ValidacaoDeInputs.inputIsvalido();
            if (respostaUsuario <= 5 && respostaUsuario > 0) {
                Funcionalidades.cadastrarProduto(respostaUsuario);

            } else if (respostaUsuario != 0) {
                System.out.println("\t\t\t[OPÇÃO INVÁLIDA]");
                telaDeCadastro();
            } else {
                telaMenuInicial();
            }
        } while (respostaUsuario != 0);
    }

    private void telaDeEstoque() {

        do {

            System.out.print("""

                    [1] ESTOQUE DE ALBUNS \t[2] ESTOQUE DE BRINQUEDOS
                    """);

            System.out.println("\tQTD ESTOQUE = [" + Album.getQuantidadeEstoqueAlbum() +
                    "]" + "\t\tQTD ESTOQUE = [" + Brinquedo.getQuantidadeEstoqueBrinquedo() + "]");
            System.out.println();
            System.out.print("[3] ESTOQUE DE FILMES \t" + "[4] ESTOQUE DE JOGOS\n");
            System.out.println("\tQTD ESTOQUE = [" + Filme.getQuantidadeEstoqueFilme() +
                    "]" + "\t\tQTD ESTOQUE = [" + Jogo.getQuantidadeEstoqueJogo() + "]");
            System.out.println();

            System.out.print("[5] ESTOQUE DE LIVROS \t" + "[6] ESTOQUE DE TODOS OS PRODUTOS\n");
            System.out.println("\tQTD ESTOQUE = [" + Livro.getQuantidadeEstoqueLivro() +
                    "]" + "\t\tQTD ESTOQUE = [" + Funcionalidades.quantidadeEstoqueTotal() + "]");
            System.out.println();
            System.out.print("[7] ALTERAR\t");
            System.out.print("\t[8] REMOVER\t");
            System.out.println("\t[9] BUSCAR POR ID\n");
            System.out.print("[10] PRODUTOS SEM ESTOQUE");
            System.out.println("\t\t[0] SAIR\n");

            respostaUsuario = ValidacaoDeInputs.inputIsvalido();
            if (respostaUsuario == 6) {
                Funcionalidades.mostraTodoEstoque();

            } else if (respostaUsuario == 1 || respostaUsuario == 2 || respostaUsuario == 3 || respostaUsuario == 4 || respostaUsuario == 5 || respostaUsuario == 10) {
                Funcionalidades.mostraEstoquePorCategoria(respostaUsuario);
                telaDeEstoque();

            } else if (respostaUsuario == 7) {
                telaAlterarProduto();

            } else if (respostaUsuario == 8) {
                telaRemoveQuantidade();

            } else if (respostaUsuario == 9) {
                telaBuscaProduto();

            } else if (respostaUsuario != 0) System.out.println("\t\t\t[OPÇÃO INVÁLIDA]");
        } while (respostaUsuario != 0);
        telaMenuInicial();

    }

    public Produtos telaBuscaProduto() {

        System.out.print("ID PRODUTO: ");

        String idDoProduto = tc.nextLine();

        if (Funcionalidades.buscarProdutoPelaID(idDoProduto) != null) {
            System.out.println(Funcionalidades.buscarProdutoPelaID(idDoProduto) + "\n");
            return Funcionalidades.buscarProdutoPelaID(idDoProduto);
        } else {
            System.out.println("\t\t[PRODUTO NÃO ENCONTRADO]");
            return null;
        }

    }

    public void telaAlterarProduto() {
        Produtos produto = telaBuscaProduto();
        if (produto != null) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t[ESOLHA QUAL INFORMAÇÃO DESEJA ALTERAR]");
            System.out.print("\t[1]NOME\t\t\t\t [2]PREÇO\t\t\t\t [3]QUANTIDADE\t\t\t\t");

            if (produto instanceof Brinquedo) {
                System.out.println(" [4]TIPO");

                respostaUsuario = ValidacaoDeInputs.inputIsvalido();
                Funcionalidades.alterarProdutoCadastrado(respostaUsuario, produto);
            } else {
                System.out.println(" [4]GENÊRO \t\t");

                if (produto instanceof Album) {
                    System.out.println(" [5]MÚSICAS OU BANDAS\t\t [6]SELOS \t");
                    respostaUsuario = ValidacaoDeInputs.inputIsvalido();
                    Funcionalidades.alterarProdutoCadastrado(respostaUsuario, produto);
                } else if (produto instanceof Filme) {
                    System.out.println(" [5]ESTÚDIOS\t\t [6]DIRETORIES\t\t [7]PRODUTORES\t\t [8]PRODUTORES");
                    respostaUsuario = ValidacaoDeInputs.inputIsvalido();
                    Funcionalidades.alterarProdutoCadastrado(respostaUsuario, produto);
                } else if (produto instanceof Jogo) {
                    System.out.println(" [5]DISTRIBUIDORA\t\t [6]ESTÚDIO");
                    respostaUsuario = ValidacaoDeInputs.inputIsvalido();
                    Funcionalidades.alterarProdutoCadastrado(respostaUsuario, produto);

                } else if (produto instanceof Livro) {
                    System.out.println(" [5]ESCRITOR\t\t [6]EDITORA");
                    respostaUsuario = ValidacaoDeInputs.inputIsvalido();
                    Funcionalidades.alterarProdutoCadastrado(respostaUsuario, produto);
                }
            }
        }
    }
    public void telaRemoveQuantidade() {

        System.out.print("ID PRODUTO PARA REALIZAR BUSCA: ");
        String idDoProduto = tc.nextLine();
        if (Funcionalidades.buscarProdutoPelaID(idDoProduto) != null) {
            System.out.print("Quantidade para remover: ");
            int quantidade = ValidacaoDeInputs.inputIsvalido();
            Funcionalidades.removeQuantidadeNoEstoqueDoProduto(idDoProduto, quantidade);

        }
    }

    public void telaCaixa() {
        System.out.println("\t\t[CAIXA]");
        System.out.println("VALOR VENDIDO: R$" + Produtos.valorVendasFormatado());
        System.out.println("[1] REALIZAR VENDA");
        System.out.println("[2] SAIR DO CAIXA");
        respostaUsuario = ValidacaoDeInputs.inputIsvalido();

        if (respostaUsuario == 1) {

            System.out.print("ID do Produto: ");
            String id = tc.nextLine();

            if (Funcionalidades.buscarProdutoPelaID(id) != null) {
                System.out.println(Funcionalidades.buscarProdutoPelaID(id));
                System.out.println("[1] Realizar Venda");
                System.out.println("[2] Cancelar Venda");
                respostaUsuario = ValidacaoDeInputs.inputIsvalido();

                if (respostaUsuario == 1) {

                    System.out.print("Quantidade: ");
                    Funcionalidades.realizarVenda(Funcionalidades.buscarProdutoPelaID(id), ValidacaoDeInputs.inputIsvalido());
                    telaCaixa();

                } else if (respostaUsuario == 2) {
                    telaCaixa();
                } else {
                    System.out.println("\t\t\t\t[OPÇÃO INVÁLIDA]");
                }
            } else System.out.println("\t\t\t[ID DE PRODUTO NÃO ENCONTRADA]");
            telaCaixa();

        } else if (respostaUsuario == 2) {
            telaMenuInicial();
        } else {
            System.out.println("\t\t\t\t[OPÇÃO INVÁLIDA]");
            telaDeCadastro();
        }

    }
}
