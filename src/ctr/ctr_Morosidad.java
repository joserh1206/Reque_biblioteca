package ctr;

import code.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ctr_Morosidad implements Initializable {

    @FXML
    private TableView<Usuario> tbv_morosidad;

    @FXML
    private TableColumn<Usuario, String> tbc_carne;

    @FXML
    private TableColumn<Usuario, String> tbc_nombre;

    @FXML
    private TableColumn<Usuario, String> tbc_apellido;

    @FXML
    private TableColumn<Usuario, String> tbc_morosidad;

    @FXML
    private TextField txt_carne;

    @FXML
    private Button btn_pagar;

    @FXML
    void realizar_pago(ActionEvent event) {
        Usuario user = Usuario.buscar_usuario(txt_carne.getText());
        if(user.getNombre().equals("error")){
            ctr_PrestamoDevolucion.alerta_error("El usuario ingresado no existe", "Error en el carné",
                    "El carné ingresado no corresponde con un usuario registrado");
        } else {
            if (Float.valueOf(user.getSaldo()) != 0f) {
                user.setSaldo(0f);
                ctr_PrestamoDevolucion.alerta_info("Pago realizado con éxito", "El pago de la morosidad fue efectuado con éxito",
                        "Pago efectuado");

            } else {
                ctr_PrestamoDevolucion.alerta_error("Ocurrió un problema durante el pago", "Se produjo un problema con el pago",
                        "El usuario ingresado no presenta morosidades");
            }
            tbv_morosidad.refresh();
        }
    }

    public ObservableList<Usuario> getUsuario(){
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        usuarios.addAll(Usuario.lista_usuarios);
        return usuarios;
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbc_apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tbc_carne.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbc_morosidad.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tbc_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tbv_morosidad.setItems(getUsuario());
    }
}
