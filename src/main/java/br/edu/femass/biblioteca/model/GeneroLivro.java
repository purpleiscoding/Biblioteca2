package br.edu.femass.biblioteca.model;

public enum GeneroLivro {
    acao("Livro de Ação"),
    comedia("Livro de Comédia"),
    terror("Livro de Terror"),
    suspense("Livro de Suspense"),
    ficcao("Livro de Ficção Científica");

    private String nome;

    GeneroLivro(String nome) {
        this.nome = nome;
    }

}
