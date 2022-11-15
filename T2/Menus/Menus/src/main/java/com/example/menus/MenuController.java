package com.example.menus;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private MenuItem menuSalir,menuComunicarDefecto,menuComunicarEspecifico,menuEscena;

    @FXML
    private RadioMenuItem menuActivado,menuDesactivado;

    @FXML
    private GridPane gridCentral;

    @FXML
    private Label textoVuelta;

    private ToggleGroup grupoMenus;

    private ContextMenu menuContextual;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        personalizarBotones();
        acciones();
    }

    private void instancias() {
        grupoMenus = new ToggleGroup();
        grupoMenus.getToggles().addAll(menuActivado,menuDesactivado);
        menuContextual = new ContextMenu();
        menuContextual.getItems().setAll(menuSalir,menuComunicarDefecto,menuComunicarEspecifico,menuEscena,menuActivado,menuDesactivado);
    }

    private void personalizarBotones() {
        menuComunicarDefecto.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("comunicar.png"))));
        menuComunicarDefecto.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        menuComunicarEspecifico.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("comunicar_esp.png"))));
        menuComunicarEspecifico.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
    }

    private void acciones() {
        menuSalir.setOnAction(new ManejoPulsaciones());
        menuComunicarDefecto.setOnAction(new ManejoPulsaciones());
        menuComunicarEspecifico.setOnAction(new ManejoPulsaciones());
        menuEscena.setOnAction(new ManejoPulsaciones());
        grupoMenus.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println(((RadioMenuItem)t1).getText());
                RadioMenuItem radioSeleccionado = (RadioMenuItem)t1;
                if (radioSeleccionado.getText().equalsIgnoreCase("Activado")){
                    menuSalir.setDisable(false);
                }else{
                    menuSalir.setDisable(true);
                }
            }
        });
        gridCentral.setOnMouseClicked(new ManejoRaton());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuSalir){
                System.exit(0);
            } 
            else if (actionEvent.getSource() == menuComunicarDefecto) {
                //1. Tener una ventana
                Stage ventana = new Stage();
                //2.  FXML --->parte grafica
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("comunicarDefecto-view.fxml"));
                //3. Tener una scene
                try {
                    Parent root = fxmlLoader.load();
                    Scene escena = new Scene(root,600,600);
                    //4. unir scene y stage
                    ventana.setScene(escena);

                    ComunicarDefectoController controller = fxmlLoader.getController();
                    controller.recepcionarTexto("Texto pasar por defecto");
                    controller.setController(MenuController.this);
                    //5. hacer visible la ventana
                    ventana.setTitle("Ventana secundaria");
                    ventana.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            else if(actionEvent.getSource() == menuComunicarEspecifico){
                
            } 
            else if (actionEvent.getSource() == menuEscena) {
                
            }

        }
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseButton.SECONDARY){
                
            }
            System.out.println("Evento raton detectado");
            menuContextual.show(gridCentral,mouseEvent.getX(),mouseEvent.getY());
        }
    }

    public void recepcionarText(String texto){
        textoVuelta.setText(texto);
    }
}