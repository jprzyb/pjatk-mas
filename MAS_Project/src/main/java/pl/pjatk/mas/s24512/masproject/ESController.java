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
import javafx.stage.WindowEvent;
import pl.pjatk.mas.s24512.masproject.Models.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class ESController implements Initializable {
    public static Employee employee;

    @FXML
    TextField employeeSalaryField;
    @FXML
    Label infoLabel;
    @FXML
    Label nameLabel;

    /**
     * Initializes the controller with initial data when the FXML file is loaded.
     *
     * @param url            The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources used to localize the root object, or null.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(nameLabel.getText() + employee);
        employeeSalaryField.setText(String.valueOf(employee.getSalary()));
    }

    /**
     * Shows the employee salary change window for the selected employee.
     *
     * @param selectedEmployee The employee whose salary is to be changed.
     * @param parent           The parent controller calling this method.
     */
    public static void showEmployeeSalaryWindow(Employee selectedEmployee, CPMController parent) {
        employee = selectedEmployee;
        try {
            FXMLLoader loader = new FXMLLoader(ESController.class.getResource("employee-salary-change.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Employee salary change");
            stage.show();
            stage.setOnHiding((WindowEvent e) -> parent.afterEmployeeSalaryChangeClose());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the set button click to update the employee's salary.
     *
     * @param event The ActionEvent triggered by clicking the set button.
     */
    @FXML
    private void onSetButtonClick(ActionEvent event) {
        if (isDouble(employeeSalaryField.getText())) {
            employee.setSalary(Double.parseDouble(employeeSalaryField.getText()));
            onCancelButtonClick(event);
        } else {
            infoLabel.setText("Wrong salary value (should be like 1234.99)");
        }
    }

    /**
     * Handles the cancel button click to close the salary change window.
     *
     * @param event The ActionEvent triggered by clicking the cancel button.
     */
    @FXML
    private void onCancelButtonClick(ActionEvent event) {
        employee = null;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Checks if a given string can be parsed into a double.
     *
     * @param value The string value to check.
     * @return True if the string can be parsed into a double, false otherwise.
     */
    private boolean isDouble(String value) {
        if (value == null || value.isEmpty()) return false;
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
