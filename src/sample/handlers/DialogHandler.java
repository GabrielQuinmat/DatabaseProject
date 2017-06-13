package sample.handlers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.controllers.DialogController;

import java.io.IOException;

/**
 * Created by Gabo on 11/06/2017.
 */
public class DialogHandler {
    private Stage primaryStage;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void openDialog(String message) throws IOException {
        primaryStage = new Stage();
        FXMLLoader fxml = new FXMLLoader();
        Parent root = fxml.load(getClass().getResource("/sample/views/DialogMessage.fxml"));
        DialogController dialogController = fxml.getController();
        dialogController.setTextDialog(message);
        primaryStage.setTitle("Mensaje de Diálogo");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void openConnectDB() throws IOException {
        primaryStage = new Stage();
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sample/views/ConnectDBScene.fxml"));
        Parent root = fxml.load();
        primaryStage.setTitle("Conexión a la Base de Datos");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.showAndWait();
    }
}
