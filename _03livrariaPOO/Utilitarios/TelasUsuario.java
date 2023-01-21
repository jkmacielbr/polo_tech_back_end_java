package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Funcionalidades;

import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.Produtos;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos.Album;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos.Filme;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos.Jogo;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos.categoriaDeProdutos.Livro;

import java.util.Scanner;

public class TelasUsuario {
    Scanner tc = new Scanner(System.in);
    int op;

    public void telaMenuInicial() {


        do {
            System.out.println("[1] CADASTRAR PRODUTO");
            System.out.println("[2] CAIXA");
            System.out.println("[3] ESTOQUE [VER | ALTERAR | REMOVER]");
            System.out.println("[0] SAIR");
            op = ValidacaoDeInputs.inputIsvalido();
            if (op != 5){

                if (op == 1) {
                    telaDeCadastro();
                } else if(op ==2){
                    if (Funcionalidades.isTemProdutoNoEsotque()) {
                        telaCaixa();
                    } else System.out.println("\t[OBRIGATÓRIO CADASTRAR AO MENOS 1 PRODUTO]");
                } else if (op == 3) {
                    if (Funcionalidades.isTemProdutoNoEsotque()) telaDeEstoque();
                    else System.out.println("\t[OBRIGATÓRIO CADASTRAR AO MENOS 1 PRODUTO NO ESTOQUE]");
                } else if (op != 0) {
                    System.out.println("\t\t\t[OPÇÃO INVÁLIDA]");

                }
            }

        } while (op != 0);

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
            op = ValidacaoDeInputs.inputIsvalido();
            if(op <= 5 && op > 0) {
                Funcionalidades.cadastrarProduto(op);

            } else if (op !=0)  {
                System.out.println("\t\t\t[OPÇÃO INVÁLIDA]");
                telaDeCadastro();
            } else {
                telaMenuInicial();
            }
        } while (op != 0);
    }
    private void telaDeEstoque() {

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
                    "]"+ "\t\tQTD ESTOQUE = [" + Livro.getQuantidadeEstoqueTotal()+"]");
            System.out.println();
            System.out.print("[7] ALTERAR\t");
            System.out.print("\t[8] REMOVER\t");
            System.out.println("\t[9] BUSCAR POR ID\n");
            System.out.print("[10] PRODUTOS SEM ESTOQUE");
            System.out.println("\t\t[0] SAIR");

            op = ValidacaoDeInputs.inputIsvalido();
            if (op == 6) {
                Funcionalidades.mostraTodoEstoque();

            } else if (op == 1 || op == 2 || op == 3 || op == 4 || op == 5 || op == 10) {
                Funcionalidades.mostraEstoquePorCategoria(op);
                telaDeEstoque();

            } else if (op == 7){
                telaAlterarProduto();

            } else if (op == 8){
                telaRemover();

            } else if (op == 9){
                telaBuscarProduto();

            }

            else if (op !=0 )System.out.println("\t\t\t[OPÇÃO INVÁLIDA]");
        } while (op != 0);
        telaMenuInicial();

    }

    public void telaBuscarProduto(){

        System.out.print("ID PRODUTO PARA REALIZAR BUSCA: ");

        String idDoProduto = tc.nextLine();

        if (Funcionalidades.buscarProdutoPelaID(idDoProduto) != null){
            System.out.println(Funcionalidades.buscarProdutoPelaID(idDoProduto));
        } else {
            System.out.println("\t\t[PRODUTO NÃO ENCONTRADO]");
        }
    }
    public void telaAlterarProduto() {
        System.out.print("ID PRODUTO PARA REALIZAR BUSCA: ");
        String idDoProduto = tc.nextLine();
        if (Funcionalidades.buscarProdutoPelaID(idDoProduto) != null) {
            System.out.println(Funcionalidades.buscarProdutoPelaID(idDoProduto));
            Funcionalidades.alterarProdutoCadastrado(Funcionalidades.buscarProdutoPelaID(idDoProduto));
        }
    }
    public void telaRemover(){

        System.out.print("ID PRODUTO PARA REALIZAR BUSCA: ");
        String idDoProduto = tc.nextLine();
        if (Funcionalidades.buscarProdutoPelaID(idDoProduto)!= null){
            System.out.print("Quantidade para remover: ");
            int quantidade = tc.nextInt();
            tc.nextLine();
            Funcionalidades.removeQuantidadeNoEstoqueDoProduto(idDoProduto, quantidade);

        }
    }

    public void telaCaixa(){
        System.out.println("\t\t[CAIXA]");
        System.out.println("VALOR VENDIDO: R$"+Produtos.getValorDeVendas());
        System.out.println("[1] REALIZAR VENDA");
        System.out.println("[2] SAIR DO CAIXA");
        op = ValidacaoDeInputs.inputIsvalido();

        if(op == 1){

            System.out.print("ID do Produto: ");
            String id = tc.nextLine();
            if(Funcionalidades.buscarProdutoPelaID(id) != null){
                System.out.println(Funcionalidades.buscarProdutoPelaID(id));
                System.out.println("[1] Realizar Venda");
                System.out.println("[2] Cancelar Venda");
                op = ValidacaoDeInputs.inputIsvalido();

                if(op == 1){
                    System.out.print("Quantidade: ");
                    Funcionalidades.realizarVenda(Funcionalidades.buscarProdutoPelaID(id), ValidacaoDeInputs.inputIsvalido());
                    telaCaixa();

                }else if (op == 2){
                    telaCaixa();
                }else {
                    System.out.println("\t\t\t\t[OPÇÃO INVÁLIDA]");
                }
            } else System.out.println("\t\t\t[ID DE PRODUTO NÃO ENCONTRADA]");
            telaCaixa();

        } else if(op == 2){
            telaMenuInicial();
        } else {
            System.out.println("\t\t\t\t[OPÇÃO INVÁLIDA]");
            telaDeCadastro();
        }

    }
}