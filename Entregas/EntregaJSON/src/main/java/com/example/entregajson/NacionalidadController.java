package com.example.entregajson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class NacionalidadController implements Initializable {
    @FXML
    private Button buscar,inicio;

    @FXML
    private TableView tabla;
    @FXML
    private TableColumn nacionalidad,probabilidad;
    @FXML
    private TextField textNombre;

    @FXML
    private ComboBox<String> combo;
    private ObservableList listaTabla;
    private ObservableList listaCombo;

    private String urlRecuperada,nombreUs,naci,prob;
    private HelloController helloController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        combo.setItems(listaCombo);
        acciones();
    }

    private void asociarDatos() {
        tabla.setItems(listaTabla);
        nacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        probabilidad.setCellValueFactory(new PropertyValueFactory<>("probabilidad"));

    }

    private void instancias() {
        listaTabla = FXCollections.observableArrayList();
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("GUARDAR", "NO GUARDAR");
    }

    private void acciones() {
        buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                nombreUs = textNombre.getText();
                intepretarJson(urlRecuperada+nombreUs);
            }
        });
        inicio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (combo.getSelectionModel().selectedItemProperty().getValue().equalsIgnoreCase("GUARDAR")){
                    naci = ((Nacionalidad)listaTabla.get(0)).getNacionalidad();
                    prob = ((Nacionalidad)listaTabla.get(0)).getProbabilidad();

                    helloController.recepcionarText(nombreUs +" - Nacionalidad->"+naci+":"+prob);

                }
                Stage ventana = (Stage) inicio.getScene().getWindow();
                ventana.close();
            }
        });

    }

    private void intepretarJson(String url) {
        listaTabla.clear();
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

            JSONObject object = new JSONObject(lecturaCompleta);
            JSONArray array = object.getJSONArray("country");
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = array.getJSONObject(i);
                String country = item.get("country_id").toString();
                String prob = item.get("probability").toString();
                listaTabla.add(new Nacionalidad(country,prob));
                asociarDatos();
            }
            //listaTabla.clear();
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

}
