package br.edu.femass.biblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("biblioteca-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 604, 356);
        stage.setTitle("Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    /*public static boolean showPersonEditDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("biblioteca-view.fxml"));
        try {
            Stage dialogStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 604, 356);
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(scene);

            // Define a pessoa no controller.
            EmprestimoController controller = fxmlLoader.getController();
            // Mostra a janela e espera até o usuário fechar.
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    public static void main(String[] args) {
        launch();
    }
}