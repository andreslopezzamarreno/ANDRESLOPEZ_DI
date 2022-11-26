package com.example.entregajson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.json.JSONObject;

public class HelloController implements Initializable {
    @FXML
    private RadioButton radioEdad,radioNacionalidad,radioGenero;

    @FXML
    private Button botonBuscar;
    @FXML
    private ListView listaCosas;
    private ToggleGroup grupoRadios;

    private ObservableList<String> cosas;

    private String url,xml,textoVuelta;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void acciones() {
        botonBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RadioButton radio = (RadioButton)grupoRadios.getSelectedToggle();
                String seleccionado = radio.getText();
                System.out.println(seleccionado);
                if(seleccionado.equalsIgnoreCase("Edad")){
                    url =  "https://api.agify.io/?name=";
                    xml = "edad-view.fxml";
                } else if (seleccionado.equalsIgnoreCase("Genero")) {
                    url = "https://api.genderize.io?name=";
                    xml = "genero-view.fxml";
                } else if (seleccionado.equalsIgnoreCase("Nacionalidad")) {
                    url = "https://api.nationalize.io/?name=";
                    xml = "nacionalidad-view.fxml";
                }
                Stage ventana = new Stage();
                //2.  FXML --->parte grafica
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(xml));
                //3. Tener una scene
                try {
                    Parent root = fxmlLoader.load();
                    Scene escena = new Scene(root,500,400);
                    //4. unir scene y stage
                    ventana.setScene(escena);

                    if(seleccionado.equalsIgnoreCase("Edad")){
                        EdadController controller = fxmlLoader.getController();
                        controller.setController(HelloController.this);
                        controller.setUrlRecuperada(url);
                    } else if (seleccionado.equalsIgnoreCase("Genero")) {
                        GeneroController controller = fxmlLoader.getController();
                        controller.setController(HelloController.this);
                        controller.setUrlRecuperada(url);
                    } else if (seleccionado.equalsIgnoreCase("Nacionalidad")) {
                        NacionalidadController controller = fxmlLoader.getController();
                        controller.setController(HelloController.this);
                        controller.setUrlRecuperada(url);
                    }

                    //5. hacer visible la ventana
                    ventana.setTitle("Ventana secundaria");
                    ventana.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioEdad,radioNacionalidad,radioGenero);
        cosas = FXCollections.observableArrayList();
    }

    public void recepcionarText(String texto){
        cosas.add(texto);
        listaCosas.setItems(cosas);
    }
}