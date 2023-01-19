package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeradorDeData {
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public static String geraDataDeCadastro(Date data){
        return dateFormat.format(data);
    }

}
