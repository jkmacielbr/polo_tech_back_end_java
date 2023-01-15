package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.Utilitario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidacaoDeInputs {

    public static int inputIsvalido (){
        Scanner entrada = new Scanner(System.in);
        int inputInformado;
        try {
            inputInformado = entrada.nextInt();
            return inputInformado;
        } catch (InputMismatchException e){
            System.out.println("\t\t[VOCÊ DEVE INFORMAR UM VALOR VÁLIDO]");
            return inputIsvalido();
        }

    }

}
