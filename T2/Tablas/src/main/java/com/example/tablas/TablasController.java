package com.example.tablas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class TablasController implements Initializable {

    @FXML
    private TableView tabla;

    @FXML
    private TableColumn columnaNombre,columnaApellido,columnaDni;

    @FXML
    private TextField campoFiltrar;

    private ObservableList listaTablas;
    private FilteredList listraFiltrada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        innstancias();
        asociarDatos();
        acciones();
    }

    private void innstancias() {
        listaTablas = FXCollections.observableArrayList();
        listaTablas.addAll(new Usuario("Juan","apellido1","12234A","correo1@correo.es",123,1));
        listaTablas.addAll(new Usuario("Lucas","apellido2","12234B","correo2@correo.es",234,2));
        listaTablas.addAll(new Usuario("Pedro","apellido3","12234C","correo3@correo.es",345,3));
        listaTablas.addAll(new Usuario("Alberto","apellido4","12234D","correo4@correo.es",567,4));
        listaTablas.addAll(new Usuario("Andres","apellido5","12234E","correo5@correo.es",678,5));

        listraFiltrada = new FilteredList<>(listaTablas);
    }

    private void asociarDatos() {
        tabla.setItems(listaTablas);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaDni.setCellValueFactory(new PropertyValueFactory<>("dni"));

    }

    private void acciones() {
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println(((Usuario) t1).getId());
            }
        });
        campoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                listraFiltrada.setPredicate(new Predicate() {
                    @Override
                    public boolean test(Object o) {
                        return ((Usuario) o).getNombre().equalsIgnoreCase(t1);
                    }
                });
            }
        });
    }
}