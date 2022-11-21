package com.example.alumnos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @FXML
    private TextField campoApellido;

    @FXML
    private TextField campoNombre;

    @FXML
    private TextField campoTelefono;

    @FXML
    private TextField campocorreo;
    @FXML
    private Button agregar;

    private AlumnosController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        agregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String nombre = campoNombre.getText();
                String apellido = campoApellido.getText();
                String correo = campocorreo.getText();
                String telefono = campoTelefono.getText();

                controller.agregarElementos(new Alumno(0,nombre,apellido,correo,telefono));
                Stage ventanaActual = (Stage)agregar.getScene().getWindow();

                ventanaActual.close();
            }
        });
    }

    public void setController(AlumnosController controller){
        this.controller = controller;
    }
}
