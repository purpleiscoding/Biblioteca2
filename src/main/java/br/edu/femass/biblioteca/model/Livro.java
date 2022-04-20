package br.edu.femass.biblioteca.model;

public class Livro {

    private String nome;
    private GeneroLivro genero;
    private Autores autores;
    private String anoLancamento;
    private String edicao;
    private Integer codigo;
    private String quantidade;

    public String getQtdEmprestado() {
        return qtdEmprestado;
    }

    public void setQtdEmprestado(String qtdEmprestado) {
        this.qtdEmprestado = qtdEmprestado;
    }

    private String qtdEmprestado;
    private static Integer proximoCodigo = 1;

    public Livro() {
        codigo = proximoCodigo;
        proximoCodigo++;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroLivro getGenero() {
        return genero;
    }

    public void setGenero(GeneroLivro genero) {
        this.genero = genero;
    }
}
