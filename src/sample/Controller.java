package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    /*SE INICIALIZAN DESDE EL CONTROLADOR TODOS LOS COMPONENTES VISUALES QUE REQUIERAN DE COMPORTAMIENTO
    PARA PODER CONTROLARLOS DESDE CÓDIGO JAVA:
    -La tabla deberá poder controlarse para poder mostrar los datos consultados
    -Los items de los menús deberán poder controlarse para 
     */
    @FXML
    TableView table;
    @FXML
    MenuItem open;
    @FXML
    MenuItem save;
    @FXML
    MenuItem prefs;
    @FXML
    MenuItem close;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
