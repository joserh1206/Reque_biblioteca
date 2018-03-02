package ctr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import code.Libro;
import code.Usuario;

public class ctr_PrestamoDevolucion {

    @FXML
    private TextField txt_carne;

    @FXML
    private TextField txt_isbn;

    @FXML
    private RadioButton rbt_prestar;

    @FXML
    private ToggleGroup pyd;

    @FXML
    private RadioButton rbt_devolver;

    @FXML
    private Button btn_aplicar;

    @FXML
    void aplicar(ActionEvent event) {
        if(rbt_prestar.isSelected()){
            Libro libro = Libro.buscar_libro(txt_isbn.getText());
            if(!libro.getNombre().equals("error")){
                if(libro.getDisponible().equals(true)) {
                    Usuario usuario = Usuario.buscar_usuario(txt_carne.getText());
                    if (!usuario.getNombre().equals("error")) {
                        if(!usuario.buscar_libro_prestamo(libro)) {
                            if (libro.getCantidad() > 0) {
                                usuario.prestamo(libro);
                                alerta_info("Exito", "Operación exitosa", "El libro fue prestado con exito");
                            } else {
                                alerta_error("No hay libros disponibles", "Error en el préstamo",
                                        "No hay libros disponibles para préstamo");
                            }
                        } else {
                            alerta_error("Error en el préstamo", "No es posible realizar el préstamo",
                                    "Al usuario ya le fue prestado el libro solicitado");
                        }
                    } else {
                        //Hacer que salte alerta de que el usuario no existe
                        alerta_error("Error durante el prestamo", "Se produjo un error con los datos ingresados",
                                "El usuario ingresado no existe");
                    }

                } else {
                    //Hacer que salte el error de que el libro ya se encuentra en prestamo
                    alerta_error("Error durante el prestamo", "Se produjo un error con los datos ingresados",
                            "El libro ingresado ya fue prestado");
                }
            } else {
                //Hacer que salte alerta de que el libro no existe
                alerta_error("Error durante el prestamo", "Se produjo un error con los datos ingresados",
                        "El libro ingresado no existe");
            }
        } else {
            Libro libro = Libro.buscar_libro(txt_isbn.getText());
            if(!libro.getNombre().equals("error")){
                Usuario usuario = Usuario.buscar_usuario(txt_carne.getText());
                if(!usuario.getNombre().equals("error")){
                    if(usuario.buscar_libro_prestamo(libro).equals(true)){
                        usuario.devolucion(libro);
                        alerta_info("Exito", "Operación exitosa", "El libro fue devuelto con exito");
                    } else {
                        //Hacer que salte alerta de que el libro no se encuentra en prestamo
                        alerta_error("Error durante la devolucion", "Se produjo un error con los datos ingresados",
                                "El libro ingresado no ha sido prestado a este usuario");
                    }
                } else {
                    //Hacer que salte alerta de que el usuario no existe
                    alerta_error("Error durante la devolucion", "Se produjo un error con los datos ingresados",
                            "El usuario ingresado no existe");
                }
            } else {
                //Hacer que salte alerta de que el libro no existe
                alerta_error("Error durante la devolucion", "Se produjo un error con los datos ingresados",
                        "El libro ingresado no existe");
            }
        }
        txt_carne.setText("");
        txt_isbn.setText("");
    }

    public static void alerta_error(String titulo, String header, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public static void alerta_info(String titulo, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
