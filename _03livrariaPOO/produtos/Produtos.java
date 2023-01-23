package br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.produtos;


import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.Utilitarios.FormataData;
import br.com.americanas.desafios.polo_tech_back_end_java._03livrariaPOO.enumProdutos.CategoriaDeProdutos;


import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;


public abstract class Produtos {

    public int quantidade;
    public String nome;
    public String idGerada;
    public BigDecimal preco;
    public CategoriaDeProdutos categoriaProduto;
    public String dataDeCadastro;
    public static BigDecimal valorDeVendas = new BigDecimal("0.000");
    public static DecimalFormat formatarPreco  = new DecimalFormat("###,##0.00");
    public static ArrayList<Produtos> produto = new ArrayList<>();

    public Produtos(int quantidade, String nome, BigDecimal preco) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        dataDeCadastro = FormataData.geraDataDeCadastro(new Date());
    }

    public String getNome() {
        return nome;
    }

    public String getIdgerada() {
        return idGerada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public static String valorVendasFormatado() {
        return formatarPreco.format(valorDeVendas);
    }

    @Override
    public String toString() {
        return
                "\t\t\t\t\tCategoria = " + categoriaProduto +
                        "\t\t\tQuantidade = " + quantidade +
                        "\t\t\tÚltima atualização = " + dataDeCadastro +
                        "\nNome = " + nome +
                        "\t\t\tPreço = R$" + formatarPreco.format(preco) +
                        "\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t[Mais Informações]";

    }

}
