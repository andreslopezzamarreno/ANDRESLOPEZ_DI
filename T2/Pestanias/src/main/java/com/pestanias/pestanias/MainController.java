package com.pestanias.pestanias;

import com.pestanias.pestanias.model.TipoPago;
import com.pestanias.pestanias.model.Usuario;
import com.pestanias.pestanias.model.UsuarioJSON;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // elementos Gráficos
    @FXML
    private TabPane panelPestanias;


    @FXML
    private Button botonNormal, botonNormal2, botonSuma, botonIgual, botonDiv,
            botonMulti, botonResta, botonComprobar, filtrar;

    @FXML
    private ToggleButton botontoggle;

    @FXML
    private RadioButton radio1, radio2, radio3, radioTodos, radioMale, radioFemale;

    @FXML
    private Label labelNombre, labelDesc, labelComision, resultado;

    @FXML
    private TextField textFieldUno, textFieldDos;


    @FXML
    private GridPane gridBotones;


    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private ChoiceBox<Usuario> choice2;

    @FXML
    private ComboBox<String> combo;
    @FXML
    private ComboBox<Usuario> combo2;

    @FXML
    private Spinner<String> spinner;
    @FXML
    private Spinner<Integer> spinnerSexo;

    @FXML
    private ListView<String> list;
    //,listaUsuario;
    @FXML
    private ListView<UsuarioJSON> listaUsuario;
    @FXML
    private ObservableList<String> listaCombo, listaChoice, listaListView;
    //,listaUsuarios;
    
    private ObservableList<UsuarioJSON> listaUsuarios;
    private ObservableList<Usuario> listaCombo2;

    private ObservableList<Integer> listaSpinner;
    private DropShadow sombraExterior;
    private ToggleGroup grupoRadios, radiosGeneros;
    private int numero;
    private String genero;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //se  ejecuta cuando se asocia la parte grafica y la logica
        instancias();
        asociarDatos();
        configurarBotones();
        acciones();
    }

    private void interpretarJSON() {
        String urlString = String.format("https://randomuser.me/api/?gender=%s&results=%d", genero,numero);
        try {
            // 1- URL
            URL url = new URL(urlString);
            // 2- Crear la conexion
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            // 3- Interpretar los datos --> BufferReader
            BufferedReader lecturaURL =
                    new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            String linea = null;
            String lecturaCompleta = "";

            while ((linea = lecturaURL.readLine()) != null) {
                lecturaCompleta += linea;
            }
            // System.out.println(lecturaCompleta);

            // 4- Pasar el string a JSON
            JSONObject objetoCompleto = new JSONObject(lecturaCompleta);
            JSONArray arrayResults = objetoCompleto.getJSONArray("results");
            for (int i = 0; i < arrayResults.length(); i++) {
                JSONObject item = arrayResults.getJSONObject(i);
                // name-title name-firt name-last image-large
                String title = item.getJSONObject("name").getString("title");
                String first = item.getJSONObject("name").getString("first");
                String last = item.getJSONObject("name").getString("last");
                String urlImage = item.getJSONObject("picture").getString("large");
                String email = item.getString("email");
                String phone = item.getString("phone");

                UsuarioJSON usuarioJSON = new UsuarioJSON(title, first, last, urlImage, email, phone);
                listaUsuarios.add(usuarioJSON);
            }
            //System.out.println(objetoInfo.getJSONObject(0).getString("gender"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void asociarDatos() {
        radio1.setUserData(new TipoPago("Tarjeta", "pago con tarjeta bancaria", 0));
        radio2.setUserData(new TipoPago("Transferencia", "pago con tranasferencia", 10));
        radio3.setUserData(new TipoPago("Paypal", "pago con paypal", 20));

        combo.setItems(listaCombo);
        choice.setItems(listaChoice);
        combo2.setItems(listaCombo2);
        spinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(listaCombo));
        list.setItems(listaListView);
        listaUsuario.setItems(listaUsuarios);
        spinnerSexo.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100));
    }

    private void configurarBotones() {
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);
        botonNormal2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormal2.setBackground(null);

        botontoggle.setBackground(null);
        botontoggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));

    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        radiosGeneros = new ToggleGroup();

        grupoRadios.getToggles().addAll(radio1, radio2, radio3);

        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("op1", "op2");
        listaChoice = FXCollections.observableArrayList();
        listaChoice.addAll("op1", "op2");
        listaCombo2 = FXCollections.observableArrayList();
        listaCombo2.addAll(new Usuario("andres", "Lopez", 1, "dfasdf"),
                new Usuario("nico", "asdsfad", 2, "asdfads"));
        listaListView = FXCollections.observableArrayList();
        listaListView.addAll("op1", "op2", "op3", "op4", "op5", "op6", "op7", "op8", "op9", "op10");

        listaUsuarios = FXCollections.observableArrayList();

        listaSpinner = FXCollections.observableArrayList();

        radiosGeneros.getToggles().addAll(radioTodos, radioMale, radioFemale);
    }

    private void acciones() {
        botonComprobar.setOnAction(new ManejoPulsaciones());
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormal2.setOnAction(new ManejoPulsaciones());
        botontoggle.setOnAction(new ManejoPulsaciones());

        filtrar.setOnAction(new ManejoPulsaciones());
        /*botonSuma.setOnAction(new ManejoPulsaciones());
        botonResta.setOnAction(new ManejoPulsaciones());
        botonMultiplicar.setOnAction(new ManejoPulsaciones());
        botonDivision.setOnAction(new ManejoPulsaciones());
         */

        //lo mismo que lo comentado justo arriba
        for (Node child : gridBotones.getChildren()) {
            if (child instanceof Button) {
                ((Button) child).setOnAction(new ManejoPulsaciones());
            }
        }

        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton radioButton = (RadioButton) t1;
                System.out.println(((TipoPago) radioButton.getUserData()).getNombre());
                System.out.println(((TipoPago) radioButton.getUserData()).getDescripcion());
                System.out.println(((TipoPago) radioButton.getUserData()).getComision());
            }
        });

        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        botonNormal2.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal2.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());

        botontoggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override

            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                System.out.println(t1);
                botonNormal.setDisable(t1);
                botonNormal2.setDisable(t1);
            }
        });

        /*textFieldUno.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                char letraPulsada= keyEvent.getCharacter().charAt(0);
                System.out.println(Character.isDigit(letraPulsada));
            }
        });

         */
        ;
        combo2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuario, Usuario t1) {
                System.out.println(t1.getNombre());
            }
        });

        list.getSelectionModel().selectionModeProperty().addListener(new ChangeListener<SelectionMode>() {
            @Override
            public void changed(ObservableValue<? extends SelectionMode> observableValue, SelectionMode selectionMode, SelectionMode t1) {
                System.out.println("Cambio en la lista" + t1);
            }
        });

        listaUsuario.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<UsuarioJSON>() {
            @Override
            public void changed(ObservableValue<? extends UsuarioJSON> observableValue, UsuarioJSON usuarioJSON, UsuarioJSON t1) {
                t1.mostrarDatos();
            }
        });
    }

    class ManejoRaton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                System.out.println("Evento raton entrante");
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(sombraExterior);
                } else botonNormal2.setEffect(sombraExterior);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                System.out.println("Evento raton saliente");
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(null);
                } else botonNormal2.setEffect(null);

            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonNormal) {
                System.out.println("Botón 1 pulsado");
                botontoggle.setSelected(true);
                System.out.println(textFieldUno.getText());
            }
            else if (actionEvent.getSource() == botonNormal2) {
                System.out.println("Botón 2 pulsado");

            }
            else if (actionEvent.getSource() == botontoggle) {
                System.out.println("Toggle pulsado");
                if (botontoggle.isSelected()) {
                    botontoggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));

                } else {
                    botontoggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));

                }
            }
            else if (actionEvent.getSource() == botonSuma) {
                if (esNumero()) {
                    int suma = (Integer.parseInt(String.valueOf(textFieldUno.getText().charAt(0))) + Integer.parseInt(String.valueOf(textFieldUno.getText().charAt(0))));
                    resultado.setText("" + suma);
                } else {
                    System.out.println("Uno de los dos campos no es un numero");
                }
            }
            else if (actionEvent.getSource() == botonResta) {
                if (esNumero()) {
                    resultado.setText(textFieldUno.getText() + textFieldDos.getText());
                } else {
                    System.out.println("Uno de los dos campos no es un numero");
                }
            }
            else if (actionEvent.getSource() == botonMulti) {
                if (esNumero()) {
                    resultado.setText(textFieldUno.getText() + textFieldDos.getText());
                } else {
                    System.out.println("Uno de los dos campos no es un numero");
                }
            }
            else if (actionEvent.getSource() == botonDiv) {
                if (esNumero()) {
                    resultado.setText(textFieldUno.getText() + textFieldDos.getText());
                } else {
                    System.out.println("Uno de los dos campos no es un numero");
                }
            }
            else if (actionEvent.getSource() == botonComprobar) {
                String seleccionCombo = combo.getSelectionModel().getSelectedItem();
                String seleccionChoice = choice.getSelectionModel().getSelectedItem();
                String seleccionSpinner = spinner.getValue();
                String seleccionLista = list.getSelectionModel().getSelectedItem();
                System.out.println(combo.getSelectionModel().getSelectedIndex());
                System.out.println(choice.getSelectionModel().getSelectedIndex());
                System.out.println(seleccionSpinner);
                System.out.println(seleccionLista);

                //combo.getSelectionModel().selectNext();
                //choice.getSelectionModel().selectNext();

                if (combo.getSelectionModel().getSelectedIndex() > -1 && choice.getSelectionModel().getSelectedIndex() > -1) {
                    System.out.printf("Seleccion de combo %s%n", seleccionCombo);
                    System.out.printf("Seleccion de choice %s%n", seleccionChoice);
                } else {
                    System.out.println("Uno de los dos elementos no tiene seleccion");
                }

            }
            else if (actionEvent.getSource() == filtrar) {
                listaUsuarios.clear();
                numero = spinnerSexo.getValue();
                RadioButton radioButton = (RadioButton) radiosGeneros.getSelectedToggle();
                genero = radioButton.getText();
                interpretarJSON();
            }
        }
        public Boolean esNumero() {
            if (Character.isDigit(textFieldUno.getCharacters().charAt(0)) &&
                    Character.isDigit(textFieldDos.getCharacters().charAt(0))) {
                return true;
            }
            return false;
        }
    }
}



