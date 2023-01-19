package br.com.americanas.desafios.polo_tech_back_end_java.livrariaPOO.produtos.Utilitarios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidacaoDeInputs {
    static Scanner entrada = new Scanner(System.in);
    public static int inputIsvalido (){

        int inputInformado;
        try {

            inputInformado = entrada.nextInt();

            return inputInformado;
        } catch (InputMismatchException e){
            System.out.println("\t\t[VOCÊ DEVE INFORMAR UM VALOR VÁLIDO]");
            entrada.next();
            return inputIsvalido();
        }

    }

}
