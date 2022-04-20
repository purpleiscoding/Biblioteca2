package br.edu.femass.biblioteca.dao;

import br.edu.femass.biblioteca.model.Biblioteca;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class BibliotecaDao implements Dao<Biblioteca>{
    private static final String ARQUIVO = "biblioteca.json";
    private static BibliotecaDados bibliotecaDados = new BibliotecaDados();

    @Override
    public void gravar(Biblioteca objeto) throws Exception {
        listar();
        bibliotecaDados.getBibliotecas().add(objeto);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.writeValue(new File(ARQUIVO), bibliotecaDados);

    }

    @Override
    public List<Biblioteca> listar() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        FileReader fr = new FileReader(ARQUIVO);
        bibliotecaDados = mapper.readValue(fr, BibliotecaDados.class);

        return bibliotecaDados.getBibliotecas();
    }

    @Override
    public void excluir(Biblioteca objeto) throws Exception {
        bibliotecaDados.getBibliotecas().remove(objeto);
    }
}
