package com.example.alumnos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {

    @FXML
    private Label campoApellido,campoCorreo,campoNombre,campoTelefono;

    @FXML
    private Button volver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //poner en las etiquetas una serie de datos
        volver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage ventanaActual = (Stage)volver.getScene().getWindow();

                ventanaActual.close();
            }
        });
    }

    public void setearAlumno(Alumno alumno){
        campoNombre.setText(alumno.getNombre());
        campoApellido.setText(alumno.getApellido());
        campoCorreo.setText(alumno.getCorreo());
        campoTelefono.setText(alumno.getTelefono());
    }
}
