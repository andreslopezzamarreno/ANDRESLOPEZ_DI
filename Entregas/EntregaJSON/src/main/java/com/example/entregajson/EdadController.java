package com.example.entregajson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class EdadController implements Initializable {

    @FXML
    private Button buscar,botonVolver;
    @FXML
    private TextField nombre;
    @FXML
    private Label edad;
    @FXML
    private Spinner spinner;
    private String urlRecuperada,nombreUs,cosaRecuperada;
    private ObservableList<String> sino;
    private HelloController helloController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acociarDatos();
        acciones();
    }

    private void acociarDatos() {
        spinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(sino));
    }

    private void instancias() {
        sino = FXCollections.observableArrayList();
        sino.addAll("SI","NO");
    }

    private void acciones() {
        buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                nombreUs = nombre.getText();
                intepretarJson(urlRecuperada+nombreUs);
            }
        });
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (spinner.getValue().toString().equalsIgnoreCase("SI")){
                    helloController.recepcionarText(nombre.getText() +" - "+ edad.getText());
                }
                //sacar la ventana donde estoy
                Stage ventana = (Stage) botonVolver.getScene().getWindow();
                ventana.close();
            }
        });
    }

    private void intepretarJson(String url) {
        try {
            // 1- URL
            URL url2 = new URL(url);
            // 2- Crear la conexion
            HttpURLConnection conexion = (HttpURLConnection) url2.openConnection();
            // 3- Interpretar los datos --> BufferReader
            BufferedReader lecturaURL =
                    new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            String linea = null;
            String lecturaCompleta = "";

            while ((linea = lecturaURL.readLine())!= null){
                lecturaCompleta+=linea;
            }
            System.out.println(lecturaCompleta);

            JSONObject array = new JSONObject(lecturaCompleta);
            edad.setText("Edad calculada: "+array.get("age").toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setController(HelloController controller){
        this.helloController = controller;
    }

    public void setUrlRecuperada(String urlRecuperada) {
        this.urlRecuperada = urlRecuperada;
    }

    public void setCosaRecuperada(String cosaRecuperada) {
        this.cosaRecuperada = cosaRecuperada;
    }
}
