class Cliente extends Usuario implements Autenticavel {
    public Cliente(String login, String senha) {
        super(login, senha);
    }

    public boolean autenticar(String senha) {
        return senha.equals(this.senha) && senha.length() > 6;
    }
}
