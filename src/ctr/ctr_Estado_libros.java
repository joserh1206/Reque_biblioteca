package ctr;

import code.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ctr_Estado_libros implements Initializable {

    @FXML
    private TableView<Libro> tbv_catalogo;

    @FXML
    private TableColumn<Libro, String> tbc_isbn;

    @FXML
    private TableColumn<Libro, String> tbc_autor;

    @FXML
    private TableColumn<Libro, String> tbc_editorial;

    @FXML
    private TableColumn<Libro, String> tbc_nombre;

    @FXML
    private TableColumn<Libro, Integer> tbc_estado;

    public ObservableList<Libro> getLibro(){
        ObservableList<Libro> libros = FXCollections.observableArrayList();
        libros.addAll(Libro.lista_libros);
        return libros;
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
        tbc_autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        tbc_editorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        tbc_estado.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tbc_isbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        tbc_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tbv_catalogo.setItems(getLibro());
//        tbv_catalogo.getColumns().addAll(tbc_autor, tbc_editorial, tbc_estado, tbc_isbn, tbc_nombre);
    }
}
