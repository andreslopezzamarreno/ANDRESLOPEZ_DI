package com.example.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ComunicarDefectoController implements Initializable {

    @FXML
    private Label textoRecuperar;
    @FXML
    private Button botonVolver;

    @FXML
    private TextField textoVolver;


    private MenuController menuController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        acciones();
    }

    private void acciones() {
        botonVolver.setOnAction(new ManejoPulsaciones());
    }

    //metodos de comunicacion
    public void recepcionarTexto(String texto){
        textoRecuperar.setText(texto);
    }

    public void setController(MenuController controller){
        this.menuController = controller;
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonVolver){
                menuController.recepcionarText(textoVolver.getText());
                //sacar la ventana donde estoy
                Stage ventana = (Stage) botonVolver.getScene().getWindow();
                ventana.close();
            }
        }
    }


}
