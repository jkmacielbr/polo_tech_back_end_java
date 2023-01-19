package br.com.americanas.polotech.desafioTwitterV2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Cadastro usuarioTwitter;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        try {

            do {
                telaMenuInicial();
                opcao = entrada.nextInt();
                menu(opcao, entrada);

            } while (opcao != 3);

            System.out.println("Porfavor informe um númeo válido");
        }finally {
            return;
        }
    }

    public static void telaMenuInicial() {
        System.out.println("\n\t\t\tBEM VINDO AO TWITTER\t");
        System.out.println("_________________________________________");
        System.out.println();
        System.out.print("[1] Login");
        System.out.print("\t");
        System.out.print("[2] Cadastro");
        System.out.print("\t");
        System.out.println("[3] Sair");

    }

    public static void menu(int opcao, Scanner entrada) {
        switch (opcao) {
            case 1 -> {
                try {
                    boolean isLogou = usuarioTwitter.nomeLogin == null;

                    System.out.print("Digite o Login: ");
                    entrada.nextLine();
                    String usuarioLogin = entrada.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senhaLogin = entrada.nextLine();

                    isLogou = usuarioTwitter.logar(usuarioLogin, senhaLogin);
                    if (isLogou) {
                        System.out.println("LOGADO COM SUCESSO");
                        int contador = 0;
                        int op;
                        do {
                            op = telaMenuTwittar();
                            switch (op) {
                                case 1 -> {
                                    usuarioTwitter.timeline();
                                    break;
                                }
                                case 2 -> {
                                    System.out.print("O que está pensando: ");
                                    String[] texto = new String[10];
                                    texto[contador] = "@" + usuarioTwitter.nomeLogin + " Tuitou: " + entrada.nextLine();
                                    usuarioTwitter.publicaTwitter(texto, contador);
                                    contador++;

                                    break;
                                }
                                default -> {
                                    break;
                                }
                            }

                        } while (op != 3);

                    } else {
                        System.out.println("Senha ou Usuário incorreto");
                    }

                } catch (NullPointerException e) {
                    System.out.println("Nenhum usuário cadastrado");

                }
            }
            case 2 -> {
                System.out.print("Digite Nome de Usuário: ");
                entrada.nextLine();
                String usuario = entrada.nextLine();

                do {
                    System.out.print("Escolha sua senha: ");
                    String senha = entrada.nextLine();
                    System.out.print("Confirme sua senha: ");
                    String confirmarSenha = entrada.nextLine();
                    usuarioTwitter = new Cadastro(usuario, senha, confirmarSenha);
                    if (usuarioTwitter.cadastraUsuario()) {
                        System.out.println("Cadastrado com Sucesso");
                    } else {
                        System.out.println("As duas senhas digitas são diferentes");

                    }
                } while (!usuarioTwitter.cadastraUsuario());
            }
            default -> {
            }
        }
    }

    public static int telaMenuTwittar() {
        System.out.print("[1] Timeline");
        System.out.print("\t");
        System.out.print("[2] Tweetar");
        System.out.print("\t");
        System.out.println("\t[3] Sair");
        Scanner entrada = new Scanner(System.in);

        return entrada.nextInt();

    }
}
