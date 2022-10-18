package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {


    @FXML
    private Button siete,ocho,nueve,multiplicar,cuatro,cinco,seis,resta,cero,dos,punto,tres,E,
            suma,igual,AC,masMenos,modulo,division,uno,sacarExtesion,registro,cerrar,seno,factorial,raiz,elevado,ln,e;
    @FXML
    private Label labelOperaciones;
    @FXML
    private BorderPane panelGeneral;
    @FXML
    private GridPane gridCalculadora,gridExtension;

    private int op1,op2,operacion;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panelGeneral.getChildren().remove(gridExtension);
        acciones();
    }

    private void acciones() {
        for (Node child : gridCalculadora.getChildren()){
            if(child instanceof Button){
                ((Button)child).setOnAction(new ManejoPulsaciones());
            }
        }
        for(Node child: gridExtension.getChildren()){
            if (child instanceof Button) {
                ((Button)child).setOnAction(new ManejoPulsaciones());
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource() == uno){
                labelOperaciones.setText(labelOperaciones.getText()+1);
            }
            else if (actionEvent.getSource() == dos) {
                labelOperaciones.setText(labelOperaciones.getText()+2);
            }
            else if (actionEvent.getSource() == tres) {
                labelOperaciones.setText(labelOperaciones.getText()+3);
            }
            else if (actionEvent.getSource() == cuatro) {
                labelOperaciones.setText(labelOperaciones.getText()+4);
            }
            else if (actionEvent.getSource() == cinco) {
                labelOperaciones.setText(labelOperaciones.getText()+5);
            }
            else if (actionEvent.getSource() == seis) {
                labelOperaciones.setText(labelOperaciones.getText()+6);
            }
            else if (actionEvent.getSource() == siete) {
                labelOperaciones.setText(labelOperaciones.getText()+7);
            }
            else if (actionEvent.getSource() == ocho) {
                labelOperaciones.setText(labelOperaciones.getText()+8);
            }
            else if (actionEvent.getSource() == nueve) {
                labelOperaciones.setText(labelOperaciones.getText()+9);
            }
            else if (actionEvent.getSource() == cero) {
                labelOperaciones.setText(labelOperaciones.getText()+0);
            }
            else if (actionEvent.getSource() == punto) {
                labelOperaciones.setText(labelOperaciones.getText()+".");
            }else if (actionEvent.getSource() == E) {

            }else if (actionEvent.getSource() == igual) {
                op2 = Integer.parseInt(String.valueOf(labelOperaciones.getText()));
                switch (operacion){
                    case 1:
                        labelOperaciones.setText(""+(op1 +op2));
                        break;
                    case 2:
                        labelOperaciones.setText(""+(op1 -op2));
                        break;
                    case 3:
                        labelOperaciones.setText(""+(op1 *op2));
                        break;
                    case 4:
                        labelOperaciones.setText(""+(op1/op2));
                        break;

                }
            }else if (actionEvent.getSource() == suma) {
                op1= Integer.parseInt(String.valueOf(labelOperaciones.getText()));
                operacion = 1;
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == resta) {
                op1= Integer.parseInt(String.valueOf(labelOperaciones.getText()));
                operacion = 2;
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == multiplicar) {
                op1= Integer.parseInt(String.valueOf(labelOperaciones.getText()));
                operacion = 3;
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == division) {
                op1= Integer.parseInt(String.valueOf(labelOperaciones.getText()));
                operacion = 4;
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == modulo) {
                op1= Integer.parseInt(String.valueOf(labelOperaciones.getText()));
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == masMenos) {

            }else if (actionEvent.getSource() == AC) {
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == sacarExtesion) {
                panelGeneral.setLeft(gridExtension);
            }
            else if (actionEvent.getSource() == registro) {

            }else if (actionEvent.getSource() == cerrar) {
                panelGeneral.getChildren().remove(gridExtension);
            }
            else if (actionEvent.getSource() == seno) {

            }else if (actionEvent.getSource() == factorial) {

            }else if (actionEvent.getSource() == raiz) {

            }else if (actionEvent.getSource() == elevado) {

            }else if (actionEvent.getSource() == ln) {

            }else if (actionEvent.getSource() == e) {

            }
        }
    }
}