package com.pestanias.pestanias;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // elementos Gráficos
    @FXML
    private TabPane panelPestanias;

    @FXML
    private Button botonNormal, botonNormal2 ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //se  ejecuta cuando se asocia la parte grafica y la logica

        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormal2.setOnAction(new ManejoPulsaciones());

    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

            if(actionEvent.getSource()== botonNormal){
                System.out.println("Boton 1 pulsado");
            } else if (actionEvent.getSource() == botonNormal2) {
                System.out.println("Boton 2 pulsado");
            }
        }
    }

}
