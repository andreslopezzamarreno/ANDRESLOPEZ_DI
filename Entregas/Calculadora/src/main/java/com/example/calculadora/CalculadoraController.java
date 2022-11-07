package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {


    @FXML
    private Button siete,ocho,nueve,multiplicar,cuatro,cinco,seis,resta,cero,dos,punto,tres,E,
            suma,igual,AC,masMenos,modulo,division,uno,sacarExtesion,registro,cerrar,seno,coseno,tangente,elevado,raiz, ocultar,borrar;
    @FXML
    private Label labelOperaciones;
    @FXML
    private BorderPane panelGeneral;
    @FXML
    private GridPane gridCalculadora,gridExtension,gridRegistro;

    @FXML
    private TextArea areaRegistro;

    private double op1,op2,resultado;
    private String operacion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panelGeneral.getChildren().remove(gridExtension);
        panelGeneral.getChildren().remove(gridRegistro);
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
        for(Node child: gridRegistro.getChildren()){
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
            }
            else if (actionEvent.getSource() == E) {
                labelOperaciones.setText(labelOperaciones.getText()+"2.718");
            }
            else if (actionEvent.getSource() == igual) {

                switch (operacion){
                    case "+":
                        op2 = Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                        resultado = op1 +op2;
                        break;
                    case "-":
                        op2 = Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                        resultado = op1 -op2;
                        break;
                    case "*":
                        op2 = Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                        resultado = op1 *op2;
                        break;
                    case "/":
                        op2 = Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                        resultado = op1 /op2;
                        break;
                    case "sin":
                        resultado = Math.sin(op1);
                        break;
                    case "cos":
                        resultado = Math.cos(op1);
                        break;
                    case "tan":
                        resultado = Math.tan(op1);
                        break;
                    case "^":
                        op2 = Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                        resultado = Math.pow(op1,op2);
                        break;
                    case "raiz":
                        resultado = Math.sqrt(op1);
                        break;

                }
                labelOperaciones.setText(""+(resultado));

                if(operacion.equalsIgnoreCase("sin")||operacion.equalsIgnoreCase("cos")||
                        operacion.equalsIgnoreCase("tan")||operacion.equalsIgnoreCase("raiz")){
                    areaRegistro.setText(areaRegistro.getText()+"\n"+operacion+op1+"="+resultado);
                }else {
                    areaRegistro.setText(areaRegistro.getText() + "\n" + op1 + operacion + op2 + "=" + resultado);
                }

            }
            else if (actionEvent.getSource() == suma) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                operacion = "+";
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == resta) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                operacion = "-";
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == multiplicar) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                operacion = "*";
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == division) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                operacion = "/";
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == modulo) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == masMenos) {

            }else if (actionEvent.getSource() == AC) {
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == seno) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                operacion = "sin";
                labelOperaciones.setText("sin"+op1);
            }
            else if (actionEvent.getSource() == coseno) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                operacion = "cos";
            }
            else if (actionEvent.getSource() == tangente) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                operacion = "tan";
            }
            else if (actionEvent.getSource() == elevado) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                operacion = "^";
                labelOperaciones.setText("");
            }
            else if (actionEvent.getSource() == raiz) {
                op1= Double.parseDouble(String.valueOf(labelOperaciones.getText()));
                operacion = "raiz";
            }
            else if (actionEvent.getSource() == sacarExtesion) {
                panelGeneral.setLeft(gridExtension);
            }
            else if (actionEvent.getSource() == registro) {
                panelGeneral.setRight(gridRegistro);
            }
            else if (actionEvent.getSource() == cerrar) {
                panelGeneral.getChildren().remove(gridExtension);
            }
            else if (actionEvent.getSource() == ocultar) {
                panelGeneral.getChildren().remove(gridRegistro);
            }
            else if (actionEvent.getSource() == borrar) {
                areaRegistro.setText("");
            }
        }
    }
}