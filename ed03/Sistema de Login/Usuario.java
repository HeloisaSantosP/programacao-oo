interface Autenticavel {
    boolean autenticar(String senha);
}

interface Gerenciavel {
    void alterarSenha(String novaSenha);
    void bloquearUsuario();
}

interface Logavel {
    void registrarLog(String operacao);
}

abstract class Usuario {
    protected String login;
    protected String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public void exibirLogin() {
        System.out.println("Login: " + login);
    }
}
