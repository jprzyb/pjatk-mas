package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.pjatk.mas.s24512.masproject.Models.Client;
import pl.pjatk.mas.s24512.masproject.Models.Company;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NCliController implements Initializable {

    @FXML
    TextField idField;
    @FXML
    TextField firstNameField;
    @FXML
    TextField lastNameField;
    @FXML
    TextField emailAddresField;
    @FXML
    TextField phoneNumberField;
    @FXML
    TextField companyNameField;
    @FXML
    TextField companyAdressField;
    @FXML
    TextField companyAccountNumberField;
    @FXML
    TextField companyIdField;
    @FXML
    ChoiceBox<Company> comapnyChoiceBox;
    @FXML
    CheckBox companyCheckBox;
    @FXML
    VBox companyVBOX;
    @FXML
    Label infoLabel;

    /**
     * Initializes the controller class.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idField.setText(String.valueOf(UUID.randomUUID()));
        companyIdField.setText(String.valueOf(UUID.randomUUID()));
        comapnyChoiceBox.getItems().addAll(Util.companies);
    }

    /**
     * Handles cancel button click event to close the current window.
     *
     * @param event The action event triggered by clicking the cancel button.
     */
    @FXML
    private void onCancelButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Handles save button click event to save client or company information.
     *
     * @param event The action event triggered by clicking the save button.
     */
    @FXML
    private void onSaveButtonClick(ActionEvent event) {
        String validation = validateInput();

        if (validation.equals("true")) {
            if (companyCheckBox.isSelected()) {
                Util.clients.add(
                        new Client(idField.getText(), firstNameField.getText(), lastNameField.getText(), emailAddresField.getText(), phoneNumberField.getText(), companyIdField.getText())
                );
                Util.companies.add(
                        new Company(companyIdField.getText(), companyNameField.getText(), companyAdressField.getText(), companyAccountNumberField.getText().trim(), false, Util.getClientsIdsByCompanyId(companyIdField.getText()))
                );
            } else {
                Util.clients.add(
                        new Client(idField.getText(), firstNameField.getText(), lastNameField.getText(), emailAddresField.getText(), phoneNumberField.getText(), comapnyChoiceBox.getSelectionModel().getSelectedItem().getId())
                );
            }
            Util.associate();
            onCancelButtonClick(event);
        } else {
            infoLabel.setText(validation);
        }
    }

    /**
     * Toggles the disable property of the company fields based on the company checkbox selection.
     */
    @FXML
    private void onNewCompanyChosen() {
        companyVBOX.setDisable(!companyCheckBox.isSelected());
    }

    /**
     * Validates the user input for creating a new client or company.
     *
     * @return A string indicating validation result ("true" for valid input, error message otherwise).
     */
    private String validateInput() {
        if (idField.getText().isEmpty()) return "Client ID field is empty!";
        else if (firstNameField.getText().isEmpty()) return "Client first name field is empty!";
        else if (lastNameField.getText().isEmpty()) return "Client last name field is empty!";
        else if (emailAddresField.getText().isEmpty()) return "Client E-mail address field is empty!";
        else if (!isEmail(emailAddresField.getText())) return "Invalid client E-mail address!";
        else if (phoneNumberField.getText().isEmpty()) return "Client phone number field is empty!";
        else if (!isInteger(phoneNumberField.getText())) return "Invalid client phone number!";
        else if (Integer.parseInt(phoneNumberField.getText()) < 100000000) return "Invalid client phone number! (try 111000111)";
        else if (!companyCheckBox.isSelected()) {
            if (comapnyChoiceBox.getSelectionModel().getSelectedItem() == null) return "No company selected!";
        } else if (companyCheckBox.isSelected()) {
            if (companyIdField.getText().isEmpty()) return "Company ID field is empty!";
            else if (companyNameField.getText().isEmpty()) return "Company name field is empty!";
            else if (companyAdressField.getText().isEmpty()) return "Company address field is empty!";
            else if (companyAccountNumberField.getText().isEmpty()) return "Company account number field is empty!";
            else if (!isInteger(companyAccountNumberField.getText().trim())) return "Invalid company account number!";
        }
        return "true";
    }

    /**
     * Checks if a given string is a valid email address.
     *
     * @param email The email address to validate.
     * @return True if the email address is valid, false otherwise.
     */
    private boolean isEmail(String email) {
        String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Checks if a given string is a valid integer.
     *
     * @param value The string to check.
     * @return True if the string represents a valid integer, false otherwise.
     */
    private boolean isInteger(String value) {
        if (value == null || value.isEmpty()) return false;
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Displays a new window for adding a new client.
     *
     * @param parent The parent controller initiating the display of the new client window.
     */
    public static void showNewClientWindow(NCController parent) {
        try {
            FXMLLoader loader = new FXMLLoader(NCliController.class.getResource("new-client-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("New Campaign");
            stage.show();
            stage.setOnHiding((WindowEvent event) -> parent.afterNewClientClose());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
