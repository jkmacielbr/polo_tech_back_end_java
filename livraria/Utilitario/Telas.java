package br.com.americanas.polotechDesafios.livraria.Utilitario;

import br.com.americanas.polotechDesafios.livraria.produtos.Produto;

import java.util.Scanner;

public class Telas {
    Scanner reposta = new Scanner(System.in);

    public void telaMenu01() {

        int op;
        do {
            System.out.println("[1] CADASTRAR PRODUTO");
            System.out.println("[2] CAIXA");
            System.out.println("[3] ESTOQUE");
            System.out.println("[0] SAIR");
            op = reposta.nextInt();
            if (op == 1) {
                telaDeCadastro();
            } else if (op == 3) {
                if (Produto.verificaSeExistiProdutoNoEstoque()) telaDeEstoque();
                else System.out.println("\t[OBRIGATÓRIO CADASTRAR AO MENOS 1 PRODUTO NO ESTOQUE]");
            }

        } while (op != 0);

    }

    private void telaDeCadastro() {
        Input enviaDados = new Input();
        Scanner tc = new Scanner(System.in);
        int respostaCadastro;

        do {
            System.out.println("CADASTRAR PRODUTOS");
            System.out.println("[1] ALBUM DE MÚSICA");
            System.out.println("[2] BRINQUEDO");
            System.out.println("[3] FILME");
            System.out.println("[4] JOGO");
            System.out.println("[5] LIVRO");

            enviaDados.cadastrarProduto(tc.nextInt());
            System.out.println("[1] PARA CONTINUAR OU QUALQUER TECLA PARA SAIR");
            respostaCadastro = tc.nextInt();
        } while (respostaCadastro == 1);
    }
    private void telaDeEstoque() {
        int opcaoDeCategoria;
        do {
            System.out.println("[1] ESTOQUE TOTAL");
            System.out.println("[2] ESTOQUE DE ALBUNS");
            System.out.println("[3] ESTOQUE DE BRINQUEDOS");
            System.out.println("[4] ESTOQUE DE FILMES");
            System.out.println("[5] ESTOQUE DE JOGOS");
            System.out.println("[6] ESTOQUE DE LIVRO");
            System.out.println("[0] SAIR");

            opcaoDeCategoria = reposta.nextInt();
            if (opcaoDeCategoria == 1) {
                Produto.imprimirEstoqueGeral();
            } else if (opcaoDeCategoria == 2 || opcaoDeCategoria == 3 || opcaoDeCategoria == 4 || opcaoDeCategoria == 5 || opcaoDeCategoria == 6) {
                Produto.imprimirEstoqueDaCategoriaInformada(opcaoDeCategoria);
            } else System.out.println("opcao invalida");
        } while (opcaoDeCategoria != 0);

    }
}
