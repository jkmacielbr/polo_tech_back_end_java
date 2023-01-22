package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios;

import java.math.BigDecimal;
import java.util.Scanner;

public class RecebeDadosDeCadastro {

    public static void receberDadosGeral(int op) {
        Scanner tc = new Scanner(System.in);
        do {
            System.out.print("Quantidade: ");
            Funcionalidades.quantidade = ValidacaoDeInputs.inputIsvalido();

        } while (!Funcionalidades.validaQuantidade(Funcionalidades.quantidade));
        System.out.print("Nome: ");
        Funcionalidades.nome = tc.nextLine();
        System.out.print("Preço: ");
        Funcionalidades.preco = BigDecimal.valueOf(ValidacaoDeInputs.inputIsvalido());
        if (op == 1 || op == 3 || op == 4 || op == 5) {
            System.out.print("Gênero: ");
            Funcionalidades.genero = tc.nextLine();
        }
    }

    public static void receberDadosAlbum() {
        Scanner tc = new Scanner(System.in);
        System.out.print("Música ou Banda: ");
        Funcionalidades.musicasOuBandas = tc.nextLine();
        System.out.print("Selo: ");
        Funcionalidades.selos = tc.nextLine();

    }

    public static void receberDadosBrinquedo() {
        Scanner tc = new Scanner(System.in);
        System.out.print("tipo: ");
        Funcionalidades.tipo = tc.nextLine();
    }

    public static void receberDadosFilme() {
        Scanner tc = new Scanner(System.in);
        System.out.print("Estudio: ");
        Funcionalidades.estudioFilmes = tc.nextLine();
        System.out.print("Diretor: ");
        Funcionalidades.diretores = tc.nextLine();
        System.out.print("Produtor: ");
        Funcionalidades.produtores = tc.nextLine();
    }

    public static void receberDadosjogo() {
        Scanner tc = new Scanner(System.in);
        System.out.print("Distribuidora: ");
        Funcionalidades.distribuidora = tc.nextLine();
        System.out.print("Estudio: ");
        Funcionalidades.estudioJogos = tc.nextLine();
    }

    public static void receberDadosLivro() {
        Scanner tc = new Scanner(System.in);
        System.out.print("Escritor: ");
        Funcionalidades.escritor = tc.nextLine();
        System.out.print("Editora: ");
        Funcionalidades.editora = tc.nextLine();
    }

}

/*CASO QUEIRA QUE OS PRODUTOS SEJAM PREENCHIDOS AUTOMÁTICAMENTE PARA TESTE, BASTA COMENTAR A CLASSE ACIMA
E DESCOMENTAR A CLASSE ABAIXO ENTRA NO MENO DE CADASTRO E IR ESCOLHENDO AS CATEGORIAS*\
 */

//public class RecebeDadosDeCadastro{
//    public static void receberDadosGeral(int op) {
//        Scanner tc = new Scanner(System.in);
//        do {
//            System.out.print("Quantidade: ");
//            Funcionalidades.quantidade = 10;
//
//        } while (!Funcionalidades.validaQuantidade(Funcionalidades.quantidade));
//        System.out.print("Nome: ");
//        Funcionalidades.nome = "Produto Teste";
//        System.out.print("Preço: ");
//        Funcionalidades.preco = BigDecimal.valueOf(10);
//        if (op == 1 || op == 3 || op == 4 || op == 5) {
//            System.out.print("Gênero: ");
//            Funcionalidades.genero = "Sem genero";
//        }
//    }
//
//    public static void receberDadosAlbum() {
//        Scanner tc = new Scanner(System.in);
//        System.out.print("Música ou Banda: ");
//        Funcionalidades.musicasOuBandas = "musica";
//        System.out.print("Selo: ");
//        Funcionalidades.selos = "sem selo";
//
//    }
//
//    public static void receberDadosBrinquedo() {
//        Scanner tc = new Scanner(System.in);
//        System.out.print("tipo: ");
//        Funcionalidades.tipo = "comparilhado";
//    }
//
//    public static void receberDadosFilme() {
//        Scanner tc = new Scanner(System.in);
//        System.out.print("Estudio: ");
//        Funcionalidades.estudioFilmes = "marvel";
//        System.out.print("Diretor: ");
//        Funcionalidades.diretores = "stelign";
//        System.out.print("Produtor: ");
//        Funcionalidades.produtores = "disney";
//    }
//
//    public static void receberDadosjogo() {
//        Scanner tc = new Scanner(System.in);
//        System.out.print("Distribuidora: ");
//        Funcionalidades.distribuidora = "eagames";
//        System.out.print("Estudio: ");
//        Funcionalidades.estudioJogos = "fifa";
//    }
//
//    public static void receberDadosLivro() {
//        Scanner tc = new Scanner(System.in);
//        System.out.print("Escritor: ");
//        Funcionalidades.escritor = "augusto";
//        System.out.print("Editora: ");
//        Funcionalidades.editora = "altabooks";
//    }
//}
