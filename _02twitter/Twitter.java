package br.com.americanas.polotech.desafioTwitterV2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Twitter {
    String twitta[] = new String[10];


    public String publicaTwitter(String[] texto, int contador) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();
        String stringDeData = dateFormat.format(data);
        return twitta[contador] = texto[contador] + " "+stringDeData;
    }

    public void timeline() {
        if (twitta[0] == null) {
            System.out.println("Timeline Vazia");
        } else {
            for (int i =0; i< twitta.length; i++){
                if(twitta[i] != null){
                System.out.println(twitta[i]);
                }
            }

        }
    }

}
