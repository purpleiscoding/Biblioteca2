package br.edu.femass.biblioteca.model;

public enum ClassificacaoLivro {
    livre("Classificação Livre"),
    dez("Classificação 10 anos"),
    doze("Classificação 12 anos"),
    quatorze("Classificação 14 anos"),
    dezesseis("Classificação 16 anos"),
    dezoito("Classificação 18 anos");

    private String nome;

    ClassificacaoLivro(String nome) {
        this.nome = nome;
    }

}
