interface Imprimivel {
    void imprimir();
}

class DocumentoTexto implements Imprimivel {
    private String titulo;
    private String conteudo;

    public DocumentoTexto(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public void imprimir() {
        System.out.println(titulo.toUpperCase());
        System.out.println(conteudo);
        System.out.println();
    }
}
