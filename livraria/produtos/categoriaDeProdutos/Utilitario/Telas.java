package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.Utilitario;

import br.com.americanas.polotechDesafios.livraria.produtos.Produtos;
import br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.*;

import java.util.Scanner;

public class Telas {

    public void telaMenu01() {

        int op;
        do {
            System.out.println("[1] CADASTRAR PRODUTO");
            System.out.println("[2] CAIXA");
            System.out.println("[3] ESTOQUE [VER | ALTERAR | REMOVER]");
            System.out.println("[0] SAIR");
            op = ValidacaoDeInputs.inputIsvalido();
            if (op != 5){

                if (op == 1) {
                    telaDeCadastro();
                } else if (op == 3) {
                    if (Produtos.isTemProdutoNoEsotque()) telaDeEstoque();
                    else System.out.println("\t[OBRIGATÓRIO CADASTRAR AO MENOS 1 PRODUTO NO ESTOQUE]");
                } else if (op != 0) {
                    System.out.println("\t\t\t[OPÇÃO INVÁLIDA]");

                }
            }

        } while (op != 0);

    }

    private void telaDeCadastro() {
        Input enviaDados = new Input();
        int respostaCadastro;

        do {
            System.out.println("\t\t[CADASTRAR PRODUTOS]");
            System.out.println("[1] ALBUM DE MÚSICA");
            System.out.println("[2] BRINQUEDO");
            System.out.println("[3] FILME");
            System.out.println("[4] JOGO");
            System.out.println("[5] LIVRO");
            System.out.println("[0] SAIR");
            respostaCadastro = ValidacaoDeInputs.inputIsvalido();
            if(respostaCadastro <= 5 && respostaCadastro > 0) {
                enviaDados.cadastrarProduto(respostaCadastro);
                //telaDeCadastro();

            } else if (respostaCadastro !=0)  {
                System.out.println("\t\t\t[OPÇÃO INVÁLIDA]");
                telaDeCadastro();
            }
        } while (respostaCadastro == 1);
    }
    private void telaDeEstoque() {
        int opcaoDeCategoria;
        do {

            System.out.print("[1] ESTOQUE DE ALBUNS \t" + "[2] ESTOQUE DE BRINQUEDOS\n");

            System.out.println("\tQTD ESTOQUE = [" + Album.getQuantidadeEstoqueAlbum()+
                    "]"+ "\t\tQTD ESTOQUE = [" + Album.getQuantidadeEstoqueBrinquedo()+"]");
            System.out.println();
            System.out.print("[3] ESTOQUE DE FILMES \t" + "[4] ESTOQUE DE JOGOS\n");
            System.out.println("\tQTD ESTOQUE = [" + Filme.getQuantidadeEstoqueFilme()+
                    "]"+ "\t\tQTD ESTOQUE = [" + Jogo.getQuantidadeEstoqueJogo()+"]");
            System.out.println();

            System.out.print("[5] ESTOQUE DE LIVROS \t" + "[6] ESTOQUE DE TOTAL\n");
            System.out.println("\tQTD ESTOQUE = [" + Livro.getQuantidadeEstoqueLivro()+
                    "]"+ "\tQTD ESTOQUE = [" + Produtos.getQuantidadeEstoqueTotal()+"]");
            System.out.println();
            System.out.print("[7] ALTERAR\t");
            System.out.print("\t[0] SAIR\t");
            System.out.println("[8] REMOVER");
            System.out.println("[9] BUSCAR POR ID");

            opcaoDeCategoria = ValidacaoDeInputs.inputIsvalido();
            if (opcaoDeCategoria == 6) {
                Produtos.mostraTodoEstoque();

            } else if (opcaoDeCategoria == 1 || opcaoDeCategoria == 2 || opcaoDeCategoria == 3 || opcaoDeCategoria == 4 || opcaoDeCategoria == 5) {
                Produtos.mostraEstoquePorCategoria(opcaoDeCategoria);
            } else if (opcaoDeCategoria == 7){

            } else if (opcaoDeCategoria == 9){
                Scanner entradaUsuario = new Scanner(System.in);
                System.out.print("ID PRODUTO PARA REALIZAR BUSCA: ");
                String idDoProduto = entradaUsuario.nextLine();

                if (Produtos.buscarProdutoPelaID(idDoProduto) != null){
                    System.out.println(Produtos.buscarProdutoPelaID(idDoProduto));
                } else {
                    System.out.println("\t\t[PRODUTO NÃO ENCONTRADO]");
                }
                telaDeEstoque();

            }

            else if (opcaoDeCategoria !=0 )System.out.println("\t\t\t[OPÇÃO INVÁLIDA]");
        } while (opcaoDeCategoria != 0);

    }
}
