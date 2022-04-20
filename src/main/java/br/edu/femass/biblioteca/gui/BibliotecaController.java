package br.edu.femass.biblioteca.gui;

import br.edu.femass.biblioteca.HelloApplication;
import br.edu.femass.biblioteca.dao.BibliotecaDao;
import br.edu.femass.biblioteca.model.*;
import javafx.application.Preloader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BibliotecaController implements Initializable {

    private BibliotecaDao bibliotecaDao = new BibliotecaDao();

    @FXML
    private ListView<Biblioteca> bibliotecaListView;

    @FXML
    private Button BtnIncluir;

    @FXML
    private Button BtnExcluir;

    @FXML
    private Button BtnGravar;

    @FXML
    private Button BtnCancelar;

    @FXML
    private Button BtnEmprestimo;

    @FXML
    private TextField TxtCodigo;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtSobrenome;

    @FXML
    private TextField TxtNomeLivro;

    @FXML
    private TextField TxtAnoLancamento;

    @FXML
    private TextField TxtEdicao;

    @FXML
    private TextField TxtQuantidade;

    @FXML
    private ComboBox<GeneroLivro> CboGenero;


    private void limparTela() {
        TxtCodigo.setText("");
        TxtAnoLancamento.setText("");
        TxtEdicao.setText("");
        TxtNome.setText("");
        TxtSobrenome.setText("");
        TxtNomeLivro.setText("");
        TxtQuantidade.setText("");
        CboGenero.setValue(null);
    }
    private void habilitarInterface(Boolean incluir) {
        TxtAnoLancamento.setDisable(!incluir);
        TxtEdicao.setDisable(!incluir);
        TxtNome.setDisable(!incluir);
        TxtSobrenome.setDisable(!incluir);
        TxtNomeLivro.setDisable(!incluir);
        TxtQuantidade.setDisable(!incluir);
        CboGenero.setDisable(!incluir);
        BtnGravar.setDisable(!incluir);
        BtnCancelar.setDisable(!incluir);
        BtnExcluir.setDisable(incluir);
        BtnIncluir.setDisable(incluir);
        BtnEmprestimo.setDisable(incluir);
    }

    private void exibirBiblioteca() {
        Biblioteca biblioteca = bibliotecaListView.getSelectionModel().getSelectedItem();
        if (biblioteca==null) return;
        TxtNome.setText(biblioteca.getLivro().getAutores().getNome());
        TxtCodigo.setText(biblioteca.getLivro().getCodigo().toString());
        TxtSobrenome.setText(biblioteca.getLivro().getAutores().getSobrenome());
        TxtEdicao.setText(biblioteca.getLivro().getEdicao());
        TxtAnoLancamento.setText(biblioteca.getLivro().getAnoLancamento());
        TxtCodigo.setText(biblioteca.getLivro().getCodigo().toString());
        CboGenero.setValue(biblioteca.getLivro().getGenero());
        TxtQuantidade.setText(biblioteca.getLivro().getQuantidade());
        TxtNomeLivro.setText(biblioteca.getLivro().getNome());

    }

    @FXML
    private void bibliotecaListView_MouseClicked(MouseEvent evento) {
        exibirBiblioteca();
    }

    @FXML
    private void bibliotecaListView_KeyPressed(KeyEvent evento) {
        exibirBiblioteca();
    }

    @FXML
    private void BtnIncluir_Action(ActionEvent evento) {
        habilitarInterface(true);
        limparTela();
        TxtNome.requestFocus();
    }

    @FXML
    private void BtnExcluir_Action(ActionEvent evento) {
        Biblioteca biblioteca = bibliotecaListView.getSelectionModel().getSelectedItem();

        if (biblioteca==null) return;

        try {
            bibliotecaDao.excluir(biblioteca);
        } catch (Exception e) {
            e.printStackTrace();
        }

        atualizarLista();

    }
    @FXML
    private void BtnGravar_Action(ActionEvent evento) {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro();
        Autores autores = new Autores();
        autores.setNome(TxtNome.getText());
        autores.setSobrenome(TxtSobrenome.getText());
        livro.setAutores(autores);
        livro.setNome(TxtNomeLivro.getText());
        livro.setGenero(CboGenero.getValue());
        livro.setAnoLancamento(TxtAnoLancamento.getText());
        livro.setEdicao(TxtEdicao.getText());
        livro.setQuantidade(TxtQuantidade.getText());
        biblioteca.setLivro(livro);
        try {
            bibliotecaDao.gravar(biblioteca);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        habilitarInterface(false);
    }
    @FXML
    private void BtnCancelar_Action(ActionEvent evento) { habilitarInterface(false); }

    @FXML
    private void BtnEmprestimo_Action(ActionEvent evento) throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Deve ser mantido pelo menos 1 livro na biblioteca. " , ButtonType.OK);
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Livro alugado para um aluno, você tem 5 dias para devolver. " , ButtonType.OK);

        Integer a = Integer.valueOf(TxtQuantidade.getText());
        if( a > 1 ){
            a = a - 1;
            TxtQuantidade.setText(a.toString());
            alert2.showAndWait();
        }else{
            alert.showAndWait();
        }
    }


    @FXML
    private void BtnEmprestimo2_Action(ActionEvent evento) throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Deve ser mantido pelo menos 1 livro na biblioteca. " , ButtonType.OK);
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Livro alugado para um professor, você tem 30 dias para devolver. " , ButtonType.OK);

        Integer a = Integer.valueOf(TxtQuantidade.getText());
        if( a > 1 ){
            a = a - 1;
            TxtQuantidade.setText(a.toString());
            alert2.showAndWait();
        }else{
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<GeneroLivro> generos = FXCollections.observableArrayList(GeneroLivro.values());
        CboGenero.setItems(generos);

        atualizarLista();
    }


    private void atualizarLista() {
        List<Biblioteca> bibliotecas = null;
        try {
            bibliotecas = bibliotecaDao.listar();
        } catch (Exception e) {
            bibliotecas = new ArrayList<Biblioteca>();
        }
        ObservableList<Biblioteca> bibliotecasOb = FXCollections.observableArrayList(bibliotecas);
        bibliotecaListView.setItems(bibliotecasOb);
    }
}