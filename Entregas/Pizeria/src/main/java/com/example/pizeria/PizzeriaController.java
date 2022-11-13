package com.example.pizeria;

import com.example.pizeria.model.Ingrediente;
import com.example.pizeria.model.Pedido;
import com.example.pizeria.model.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PizzeriaController implements Initializable {

    @FXML
    private Button realizarPedido;
    @FXML
    private TextField fieldNombre, fieldTelefono;
    @FXML
    private RadioButton familiar, mediana, pequenia;
    @FXML
    private ComboBox<String> tipoPizzas;
    @FXML
    private ListView<Pedido> pedidos;
    private ObservableList<String> listPizzas;
    private ObservableList<Pedido> pedidoObservableList;
    private ToggleGroup tamanioPizza;
    private int id = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }
    private void instancias() {
        tamanioPizza = new ToggleGroup();
        listPizzas = FXCollections.observableArrayList();
        listPizzas.addAll("Barbacoa", "Hawaiana", "Jamon y Queso", "Cuatro quesos");
        pedidoObservableList = FXCollections.observableArrayList();
    }
    private void asociarDatos() {
        tamanioPizza.getToggles().addAll(familiar, mediana, pequenia);
        tipoPizzas.setItems(listPizzas);
    }
    private void acciones() {
        realizarPedido.setOnAction(new ManejoPulsaciones());
    }
    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        private int precio;

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == realizarPedido) {
                id++;
                String nombre = fieldNombre.getText();
                String telefono = fieldTelefono.getText();
                RadioButton seleccionado = (RadioButton) tamanioPizza.getSelectedToggle();
                String tipo = tipoPizzas.getSelectionModel().selectedItemProperty().getValue();
                ArrayList<Ingrediente> ingredientes = new ArrayList<>();
                ingredientes.clear();

                if (!nombre.equals("") & !telefono.equals("")) {
                    switch (tipo) {
                        case "Barbacoa":
                            ingredientes.add(new Ingrediente("bacon"));
                            ingredientes.add(new Ingrediente("Salasa barbacoa"));
                            ingredientes.add(new Ingrediente("Main"));
                            ingredientes.add(new Ingrediente("Cebolla"));
                            ingredientes.add(new Ingrediente("carne"));
                            switch (seleccionado.getText()) {
                                case "familiar" -> precio = 15;
                                case "mediana" -> precio = 12;
                                case "pequenia" -> precio = 7;
                            }
                            break;
                        case "Hawaiana":
                            ingredientes.add(new Ingrediente("Piña"));
                            ingredientes.add(new Ingrediente("Jamon"));
                            ingredientes.add(new Ingrediente("Salsa"));
                            switch (seleccionado.getText()) {
                                case "familiar" -> precio = 13;
                                case "mediana" -> precio = 10;
                                case "pequenia" -> precio = 5;
                            }
                            break;
                        case "Jamon y Queso":
                            ingredientes.add(new Ingrediente("Queso"));
                            ingredientes.add(new Ingrediente("jamon"));
                            switch (seleccionado.getText()) {
                                case "familiar" -> precio = 10;
                                case "mediana" -> precio = 8;
                                case "pequenia" -> precio = 4;
                            }
                            break;
                        case "Cuatro quesos":
                            ingredientes.add(new Ingrediente("Queso gorgonzola"));
                            ingredientes.add(new Ingrediente("Queso parmesano"));
                            ingredientes.add(new Ingrediente("Queso roquefort"));
                            ingredientes.add(new Ingrediente("Queso gouda"));
                            switch (seleccionado.getText()) {
                                case "familiar" -> precio = 17;
                                case "mediana" -> precio = 13;
                                case "pequenia" -> precio = 8;
                            }
                            break;
                    }
                    Pizza pizza = new Pizza(tipo, seleccionado.getText(), ingredientes, precio);
                    pedidoObservableList.add(new Pedido(id, nombre, telefono, pizza));
                    pedidos.setItems(pedidoObservableList);
                }
                fieldNombre.setText("");
                fieldTelefono.setText("");
            }
        }
    }
}