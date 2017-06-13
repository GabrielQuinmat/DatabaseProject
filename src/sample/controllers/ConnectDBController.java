package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.handlers.DialogHandler;
import sample.handlers.JDBCHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gabo on 11/06/2017.
 */
public class ConnectDBController implements Initializable {

    @FXML
    TextField urlTF;
    @FXML
    TextField userTF;
    @FXML
    PasswordField passwordTF;
    @FXML
    Button connectB;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectB.setOnAction(event -> {
            if (userTF.getText() == null || passwordTF.getText() == null || urlTF.getText() == null) {
                DialogHandler dialogHandler = new DialogHandler();
                try {
                    dialogHandler.openDialog("LOS CAMPOS NO DEBEN ESTAR VACÍOS");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                MainController.jdbcHandler = new JDBCHandler(urlTF.getText(), userTF.getText(), passwordTF.getText());
                connectB.getScene().getWindow().hide();
            }
        });
    }
}
