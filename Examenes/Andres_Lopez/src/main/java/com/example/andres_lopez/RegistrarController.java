package com.example.andres_lopez;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarController implements Initializable {

    @FXML
    private TextField textNombre,textPass,textCorreo,textApellido;

    @FXML
    private Button botonRegistrar,botonCerrar;

    @FXML
    private ComboBox comboRol;

    private ObservableList <String>arrayRoles;

    private HelloController controller;
    private Usuario usuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        leerJson();
        asociarDatos();
        acciones();
    }
    private void instancias() {
        arrayRoles = FXCollections.observableArrayList();
    }
    private void leerJson() {
        String url = "https://run.mocky.io/v3/48686b58-bd41-4f13-92c5-1fba0c56e74d";
        URL obj = null;
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONArray myResponse = new JSONArray(response.toString());
            for (int i = 0; i < myResponse.length(); i++) {
                arrayRoles.add(myResponse.get(i).toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void asociarDatos() {
        comboRol.setItems(arrayRoles);
    }
    private void acciones() {
        botonRegistrar.setOnAction(new ManejoPulsaciones());
        botonCerrar.setOnAction(new ManejoPulsaciones());
    }

    public class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonRegistrar){
                if (textNombre.getText().isEmpty()||textCorreo.getText().isEmpty()||textPass.getText().isEmpty()
                ||textApellido.getText().isEmpty()||comboRol.getSelectionModel().isEmpty()){
                    System.out.println("Falta algun dato por rellenar");
                }else {
                    usuario = new Usuario(textNombre.getText(),textApellido.getText(),textCorreo.getText(),
                            textPass.getText(),comboRol.getSelectionModel().getSelectedItem().toString());
                    System.out.println(usuario.getRol().toString()+usuario.getNombre().toString());
                    controller.setUsuarioPasado(usuario);
                }
            }
            if (actionEvent.getSource() == botonCerrar){
                Stage ventana = (Stage) botonCerrar.getScene().getWindow();
                ventana.close();
            }
        }
    }

    public void setController(HelloController controller) {
        this.controller = controller;
    }
}
