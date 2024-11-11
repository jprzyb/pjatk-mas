package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.pjatk.mas.s24512.masproject.Models.CommunicationPlannerManager;
import pl.pjatk.mas.s24512.masproject.Models.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class MIController implements Initializable {

    @FXML
    TextField firstNameField;
    @FXML
    TextField roleField;
    @FXML
    TextField loginField;
    @FXML
    TextField passwordField;
    @FXML
    Label passInfoLabel;
    @FXML
    TextField managerField;
    @FXML
    TextField birthDateField;
    @FXML
    TextField employmentDateField;
    @FXML
    TextField salaryBaseField;
    @FXML
    TextField salaryFinalField;
    @FXML
    TextField levOfEduField;

    /**
     * Initializes the controller class.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Employee e = Util.LOGGED_ON_EMPLOYEE;
        firstNameField.setText(e.getFirstName() + " " + e.getLastName());
        roleField.setText(String.valueOf(Util.LOGGED_ON_ROLE));
        loginField.setText(e.getLogin());
        passwordField.setText(e.getPassword());
        CommunicationPlannerManager m = Util.getManagerBySubordinateId(e.getId());
        if (m == null) managerField.setText("N/A");
        else managerField.setText(m.getFirstName() + " " + m.getLastName());
        birthDateField.setText(String.valueOf(e.getBirthDate()));
        employmentDateField.setText(String.valueOf(e.getEmploymentDate()));
        salaryBaseField.setText(String.valueOf(e.getSalary()));
        salaryFinalField.setText(String.valueOf(e.getSalary() * e.getEducationLevel().getFactor()));
        levOfEduField.setText(String.valueOf(e.getEducationLevel().getEducationType()));
    }

    /**
     * Sets the password for the logged-in employee.
     */
    @FXML
    private void setPassword() {
         Util.LOGGED_ON_EMPLOYEE.setPassword(passwordField.getText());
    }

    /**
     * Sets the login for the logged-in employee.
     */
    @FXML
    private void setLogin() {
        Util.LOGGED_ON_EMPLOYEE.setLogin(loginField.getText());
    }

    /**
     * Handles the 'OK' button click to close the window.
     *
     * @param event The action event triggered by clicking the 'OK' button.
     */
    @FXML
    private void onOkClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Shows the window with logged-in employee information.
     *
     * @param parent The parent controller initiating the display of the information window.
     */
    public static void showMyInformation(CPController parent) {
        try {
            FXMLLoader loader = new FXMLLoader(MIController.class.getResource("my-information-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("My information");
            stage.show();
            stage.setOnHiding((windowEvent -> parent.afterMyInfoClose()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
