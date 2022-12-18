package br.com.americanas.polotech.desafioTwitterV2;


public class Cadastro extends Twitter {

    String nomeLogin = "";
    String senhaLogin, confirmaSenha;

    public Cadastro() {

    }

    public Cadastro(String nomeLogin, String senhaLogin, String confirmaSenha) {
        this.nomeLogin = nomeLogin;
        this.senhaLogin = senhaLogin;
        this.confirmaSenha = confirmaSenha;
    }

    public boolean cadastraUsuario() {
        if (senhaLogin.equals(confirmaSenha)) {
            return true;
        }
        return false;
    }
    public boolean logar(String usuario, String senhaLogin){

        if (usuario.equals(this.nomeLogin) && senhaLogin.equals(this.senhaLogin)){
            return true;
        } return false;
    }


}
