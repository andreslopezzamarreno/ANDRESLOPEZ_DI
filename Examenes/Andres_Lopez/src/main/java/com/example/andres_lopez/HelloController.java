package com.example.andres_lopez;

import com.almasb.fxgl.net.UDPClientConfig;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField textUsuario,textContrasenia;
    @FXML
    private Button botonRegistrar,botonAcceder;

    private ObservableList<Usuario> arrayUsuarios;

    private Usuario usuarioPasado;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {
        arrayUsuarios = FXCollections.observableArrayList();
        arrayUsuarios.add(new Usuario("andres","lopez","andres.lopez","123","Admin"));
        arrayUsuarios.add(new Usuario("andres2","lopez","andres.lopez","123","Developer"));
    }

    private void acciones() {
        botonRegistrar.setOnAction(new ManejoPulsaciones());
        botonAcceder.setOnAction(new ManejoPulsaciones());
    }

    public class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

            boolean existe = false;

            if(actionEvent.getSource() == botonRegistrar){
                Stage ventana = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registrar-view.fxml"));
                try {
                    Parent parent = fxmlLoader.load();
                    Scene escena  = new Scene(parent,600,600);
                    ventana.setScene(escena);
                    RegistrarController controllerReg = fxmlLoader.getController();
                    controllerReg.setController(HelloController.this);
                    ventana.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(actionEvent.getSource() == botonAcceder){
                for (int i = 0; i < arrayUsuarios.size(); i++) {

                    Usuario usuario = arrayUsuarios.get(i);
                    if (usuario.getNombre().equalsIgnoreCase(textUsuario.getText())&&
                            usuario.getContraseña().equalsIgnoreCase(textContrasenia.getText())&&
                    usuario.getRol().equalsIgnoreCase("Admin")){
                        Stage ventana = new Stage();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("acceder-view.fxml"));
                        try {
                            Parent parent = fxmlLoader.load();
                            Scene escena  = new Scene(parent,600,600);
                            ventana.setScene(escena);
                            AccederController controller = fxmlLoader.getController();
                            controller.setListaUsuarios(arrayUsuarios);
                            ventana.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        existe = true;
                    } else if (usuario.getNombre().equalsIgnoreCase(textUsuario.getText())&&
                            usuario.getContraseña().equalsIgnoreCase(textContrasenia.getText())) {
                        System.out.println("El Usurio no tiene los suficientes Privilegios");
                        existe = true;
                    }
                }
                if (!existe){
                    System.out.println("El usuario no existe");
                }

            }
        }
    }

    public void setUsuarioPasado(Usuario usuarioPasado) {
        arrayUsuarios.add(usuarioPasado);
    }
}