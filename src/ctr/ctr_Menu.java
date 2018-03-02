package ctr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ctr_Menu {

    @FXML
    private Button btn_estado_libros;

    @FXML
    private Button btn_consultar_morosidad;

    @FXML
    private Button btn_catalogo;

    @FXML
    private Button btn_rprestamo;

    @FXML
    private Button btn_devolucion;

    @FXML
    private Button btn_morosidad;

    @FXML
    void consultar_estado_libros(ActionEvent event) throws IOException {
        CrearVentana("../ui/estado_libros.fxml", event, "Estado de los libros");
    }

    @FXML
    void consultar_morosidad(ActionEvent event) throws IOException {
        CrearVentana("../ui/morosidad.fxml", event, "Morosidades");
    }

    @FXML
    void realizar_devolucion(ActionEvent event) throws IOException {
        CrearVentana("../ui/prestamo_devolucion.fxml", event, "Devolución de libros");
    }

    @FXML
    void realizar_prestamo(ActionEvent event) throws IOException {
        CrearVentana("../ui/prestamo_devolucion.fxml", event, "Préstamo de libros");
    }

    @FXML
    void ver_catalogo_libros(ActionEvent event) throws IOException {
        CrearVentana("../ui/estado_libros.fxml", event, "Catálogo de libros");
    }

    private void CrearVentana(String ruta, ActionEvent event, String tiulo) throws IOException {
        Parent Ventana_parent = FXMLLoader.load(getClass().getResource(ruta));
        Scene Ventana_scene = new Scene(Ventana_parent);
        Stage App_Stage2 = new Stage();
        App_Stage2.setScene(Ventana_scene);
        App_Stage2.setTitle(tiulo);
        App_Stage2.setResizable(false);
        App_Stage2.show();
    }

}
