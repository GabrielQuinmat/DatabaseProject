package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gabo on 11/06/2017.
 */
public class DialogController implements Initializable {

    @FXML
    Text textDialog;

    public void setTextDialog(String text) {
        textDialog.setText(text);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
