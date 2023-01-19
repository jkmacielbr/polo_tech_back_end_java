package br.com.americanas.polotechDesafios.livraria.produtos.categoriaDeProdutos.Utilitario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerarData {
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public static String geraDataDeCadastro(Date data){
        return dateFormat.format(data);
    }

}
