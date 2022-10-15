package com.pestanias.pestanias;

import com.pestanias.pestanias.model.TipoPago;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // elementos Gráficos
    @FXML
    private TabPane panelPestanias;

    @FXML
    private Button botonNormal, botonNormal2 ;

    @FXML
    private ToggleButton botontoggle;

    @FXML
    private RadioButton radio1,radio2,radio3;

    @FXML
    private Label nombreTipo,descripcionTipo, comisionTipo;
    private DropShadow sombraExterior;
    private ToggleGroup grupoRadios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //se  ejecuta cuando se asocia la parte grafica y la logica

        asociarDatos();
        instancias();
        acciones();
        configurarBotones();
    }

    private void asociarDatos() {
        radio1.setUserData(new TipoPago("Tarjeta","pago con tarjeta bancaria",0));
        radio2.setUserData(new TipoPago("Transferencia","pago con tranasferencia",10));
        radio3.setUserData(new TipoPago("Paypal","pago con paypal",20));
    }

    private void configurarBotones(){
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);
        botonNormal2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormal2.setBackground(null);
        botontoggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
        botontoggle.setBackground(null);
    }

    private void instancias(){
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1,radio2,radio3);
    }

    private void acciones(){
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormal2.setOnAction(new ManejoPulsaciones());
        botontoggle.setOnAction(new ManejoPulsaciones());
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton radioButton = (RadioButton) t1;
                System.out.println(((TipoPago)radioButton.getUserData()).getNombre());
                System.out.println(((TipoPago)radioButton.getUserData()).getDescripcion());
                System.out.println(((TipoPago)radioButton.getUserData()).getComision());
            }
        });

        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED,new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED,new ManejoRaton());

        botonNormal2.addEventHandler(MouseEvent.MOUSE_ENTERED,new ManejoRaton());
        botonNormal2.addEventHandler(MouseEvent.MOUSE_EXITED,new ManejoRaton());

        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED,new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED,new ManejoRaton());

        botontoggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                System.out.println(t1);
                botonNormal.setDisable(t1);
                botonNormal2.setDisable(t1);

            }
        });

    }

    class ManejoRaton implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                System.out.println("Evento raton entrante");
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(sombraExterior);
                }else botonNormal2.setEffect(sombraExterior);
            }else if(mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                System.out.println("Evento raton saliente");
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(null);
                }else botonNormal2.setEffect(null);

            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

            if(actionEvent.getSource()== botonNormal){
                System.out.println("Botón 1 pulsado");
                botontoggle.setSelected(true);
            } else if (actionEvent.getSource() == botonNormal2) {
                System.out.println("Botón 2 pulsado");

            } else if (actionEvent.getSource() == botontoggle) {
                System.out.println("Toggle pulsado");
                if (botontoggle.isSelected()){
                    botontoggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));

                }else {
                    botontoggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));

                }
            }
        }
    }
}
