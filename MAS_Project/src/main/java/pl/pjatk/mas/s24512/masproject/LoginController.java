package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pjatk.mas.s24512.masproject.Models.enums.RoleType;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    TextField loginField;
    @FXML
    PasswordField passField;
    @FXML
    Label infoLabel;

    /**
     * Initializes the controller when the FXML file is loaded.
     *
     * @param url The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources used to localize the root object, or null.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Handles the login button click event.
     *
     * @param event The ActionEvent triggered by clicking the login button.
     */
    @FXML
    private void login(ActionEvent event){
//        System.out.println("Logging in by: " + loginField.getText() + " " + passField.getText());
        if(!Util.validateLogin(loginField.getText(), passField.getText())){
            infoLabel.setText("Invalid credentials!");
//            System.out.println("Invalid credentials!");
            return;
        }
        String loggedOnId = Util.getEmployeeIdByLogin(loginField.getText());
//        System.out.println(loggedOnId);
        if(loggedOnId.isEmpty()) {
            infoLabel.setText("Not implemented yet");
            return;
        }
        Util.LOGGED_ON_ROLE = Util.getRoleById(loggedOnId);
        Util.LOGGED_ON_EMPLOYEE = Util.getEmployeeById(loggedOnId);

        changeView(event);
    }

    /**
     * Changes the view after successful login based on the logged-in user's role.
     *
     * @param event The ActionEvent triggered by the login button click.
     */
    private void changeView(ActionEvent event){
        String viewType = "NONE";
        if(Util.LOGGED_ON_ROLE.equals(RoleType.COMMUNICATION_PLANNER)) viewType = "planner-view.fxml";
        else viewType = "planner-manager-view.fxml";

        Stage stage;
        Scene scene;
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource(viewType)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setOnHiding((WindowEvent) -> Util.saveData());
        stage.show();
    }

    /**
     * Sets the scene to the login view upon logging off.
     *
     * @param event The ActionEvent triggered by logging off.
     */
    public static void setToLogOffScene(ActionEvent event){
        Stage stage;
        Scene scene;
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("login-view.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setOnHiding((WindowEvent) -> Util.saveData());
        stage.show();
    }
}
