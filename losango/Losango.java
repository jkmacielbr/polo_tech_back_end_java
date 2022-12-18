package br.com.americanas.polotech.losango;

import java.util.Scanner;

public class Losango {
    public static void main(String[] args) {
        int numero, simbolos, emBrancos = 1;
        int auxiliarBrancos = emBrancos;

        System.out.println("Digite a Quantidade de colunas: ");
        do {
            Scanner tc = new Scanner(System.in);
            numero = tc.nextInt();
            if (numero < 5) {
                System.out.println("A quantidade de colunas precisa ser Igual ou Maior que 5");
            }

        } while (numero < 5);

        simbolos = (numero - 1) / 2;

        int auxiliar = simbolos;
        int auxiliarPar = 0;

        //IF PARA ALTERAR OS ESPACOS CASO SEJA NUMERO PAR
        if (numero % 2 == 0) {
            emBrancos = 2;
            auxiliarBrancos = 2;
            auxiliarPar++;

        }

        //Imprimindo a parte de cima do diamante
        //IMPRIMIR A PRIMEIRA LINHA COM CINCO ASTERISTICO
        for (int l1 = 0; l1 < numero; l1++) {
            System.out.print("*");
        }
        //PULA UMA LINHA APÓS IMPRESSAO DA PRIMEIRA
        System.out.println();

        for (int i = 1; simbolos > 0; i++) {

            //ASTERISTICOS EXTERNO LADO ESQUERDO
            for (int j = 1; j <= simbolos; j++) {
                System.out.print("*");
            }

            // PARTE INTERNA COM ESPAÇOS
            for (int count = 1; count <= emBrancos; count++) {
                System.out.print(" ");
            }
            //ASTERISTICOS EXTERNO DO LADO DIREITO
            for (int count = 1; count <= simbolos; count++) {
                System.out.print("*");
            }
            simbolos--;
            emBrancos += 2;
            System.out.println();
        }

        //ASTERISTICOS EXTERNO LADO ESQUERDO
        for (int i = auxiliar - 1 + auxiliarPar; i >= 1; i--) {
            for (int j = i; j <= auxiliar + auxiliarPar; j++) {
                System.out.print("*");
            }
            // PARTE INTERNA COM ESPAÇOS
            for (int j = 1; j <= (2 * i) - auxiliarBrancos; j++) {
                System.out.print(" ");
            }
            //ASTERISTICOS EXTERNO DO LADO DIREITO
            for (int j = i; j <= auxiliar + auxiliarPar; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        if (numero % 2 != 0)
            for (int linhaFim = 0; linhaFim < numero; linhaFim++) {
                System.out.print("*");
            }
    }
}

