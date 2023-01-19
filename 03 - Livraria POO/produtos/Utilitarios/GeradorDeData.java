package br.com.americanas.polotechDesafios.livraria.produtos.Utilitarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeradorDeData {
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public static String geraDataDeCadastro(Date data){
        return dateFormat.format(data);
    }

}
