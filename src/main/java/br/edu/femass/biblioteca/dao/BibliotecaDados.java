package br.edu.femass.biblioteca.dao;

import br.edu.femass.biblioteca.model.Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDados {
    private List<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }
}
