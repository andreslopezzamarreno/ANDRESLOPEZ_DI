package com.example.alumnos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.SearchableComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AlumnosController implements Initializable {
    @FXML
    private TableColumn identificador,nombre,correo;

    @FXML
    private Button botonAgregar,botonEliminar,botonDetalle;

    @FXML
    private MenuItem menuAgregar,menuDetalle,menuEliminar;

    @FXML
    private TableView<Alumno>tabla;


    private ObservableList<Alumno> listaTabla;

    private int contador= 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        configurarTabla();
        acciones();
    }

    private void configurarTabla() {
        tabla.setItems(listaTabla);
        identificador.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    }

    private void instancias() {
        listaTabla = FXCollections.observableArrayList();
        listaTabla.add(new Alumno(contador,"Alumno1","Correo1","23234234","apellido1"));
        contador ++;
    }

    public void agregarElementos(Alumno alumno){
        alumno.setId(contador);
        listaTabla.add(alumno);
        contador ++;
    }

    private void acciones() {
        botonAgregar.setOnAction(new ManejoPulsaciones());
        menuEliminar.setOnAction(new ManejoPulsaciones());
        botonDetalle.setOnAction(new ManejoPulsaciones());
        botonEliminar.setOnAction(new ManejoPulsaciones());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAgregar || actionEvent.getSource() == menuAgregar){
                Stage ventanaAdd = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-view.fxml"));
                try {
                    Parent parent = fxmlLoader.load();
                    Scene escenaAdd = new Scene(parent,400,400);
                    ventanaAdd.setScene(escenaAdd);
                    ventanaAdd.show();

                    AddController controller = fxmlLoader.getController();
                    controller.setController(AlumnosController.this);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            else if (actionEvent.getSource() == botonDetalle||actionEvent.getSource() == menuDetalle) {
                if (tabla.getSelectionModel().getSelectedIndex()>-1){
                    //detalle
                    Stage ventanaDetalle = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("detail-view.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(),400,400);
                        DetailController detailController = fxmlLoader.getController();
                        detailController.setearAlumno(tabla.getSelectionModel().getSelectedItem());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ventanaDetalle.setScene(scene);
                    ventanaDetalle.show();
                }else{
                    System.out.println("No hay nada seleccionado");
                }
            }
            else if (actionEvent.getSource() == botonEliminar|| actionEvent.getSource() == menuEliminar) {
                if (tabla.getSelectionModel().getSelectedIndex()>-1){
                    //borro
                    listaTabla.remove(tabla.getSelectionModel().getSelectedIndex());
                }else{
                    System.out.println("No hay nada seleccionado");
                }
            }
        }
    }
}