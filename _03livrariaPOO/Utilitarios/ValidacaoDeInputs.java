package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios;

import java.math.BigDecimal;
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

    public static BigDecimal inputIsReal (){

        BigDecimal inputInformado;
        try {

            inputInformado = entrada.nextBigDecimal();

            return inputInformado;
        } catch (InputMismatchException e){
            System.out.println("\t\t[INFORMAR UM VALOR NO PADRÃO R$] EX: --> 100,00 OU 1.000,00");
            entrada.next();
            return inputIsReal();
        }

    }

}
