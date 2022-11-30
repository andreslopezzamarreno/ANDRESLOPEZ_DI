package com.example.andres_lopez;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class AccederController implements Initializable {

    @FXML
    private TableView<Usuario> tabla;
    @FXML
    private TableColumn nombre,correo,rol;
    @FXML
    private RadioMenuItem guest,user,developer,test,all;

    private ToggleGroup grupoMenus;

    private ObservableList<Usuario>listaUsuarios;
    private FilteredList<Usuario> listaFiltrada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void instancias() {
        grupoMenus = new ToggleGroup();
        grupoMenus.getToggles().addAll(guest,user,developer,test,all);
    }

    private void acciones() {
        test.setOnAction(new EventHandler<ActionEvent>() {
            //todo: hacer lo de abajo para todos los roles
            @Override
            public void handle(ActionEvent actionEvent) {
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return usuario.getRol().equalsIgnoreCase("rol");
                    }
                });
            }
        });
    }


    private void asociarDatos() {
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
    }

    public void setListaUsuarios(ObservableList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        tabla.setItems(listaUsuarios);
    }
}
