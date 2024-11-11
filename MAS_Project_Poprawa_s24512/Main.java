package pl.pjatk.mas.s24512.masproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pjatk.mas.s24512.masproject.Models.Accountant;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class Main extends Application {

    /**
     * The main entry point for JavaFX applications.
     *
     * @param stage The primary stage for the application, onto which the application scene can be set.
     * @throws IOException If the FXML file loading fails.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MAS_s24512_GUI");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method to launch the JavaFX application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        Util.loadData();
        Util.associate();
        launch();
    }
}
