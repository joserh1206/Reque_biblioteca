package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        Usuario usuario1 = new Usuario("2016093725", "Jose Luis", "Rodriguez");
        Usuario usuario2 = new Usuario("2016093730", "Rolando", "Moya");
        Libro libro1 = new Libro("01", "Ingles 2", "Marco F", "2015", "UCR");
        Libro libro2 = new Libro("02", "Java", "Alvao R", "2016", "TEC");

        Usuario.nuevo_usuario(usuario1);
        Usuario.nuevo_usuario(usuario2);

        Libro.nuevo_libro(libro1);
        Libro.nuevo_libro(libro2);

        launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/menu.fxml"));
        Parent parent = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Menu principal");
        stage.setResizable(false);
        stage.show();
    }
}
