package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.pjatk.mas.s24512.masproject.Models.Campaign;
import pl.pjatk.mas.s24512.masproject.Models.Client;
import pl.pjatk.mas.s24512.masproject.Models.Plan;
import pl.pjatk.mas.s24512.masproject.Models.enums.ChannelType;
import pl.pjatk.mas.s24512.masproject.Models.enums.SettlementType;
import pl.pjatk.mas.s24512.masproject.Models.enums.SizeType;
import pl.pjatk.mas.s24512.masproject.Models.enums.StatusType;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.ResourceBundle;
import java.util.UUID;

public class NCController implements Initializable {

    @FXML
    TextField idField;
    @FXML
    TextField nameField;
    @FXML
    DatePicker startDateDatePicker;
    @FXML
    DatePicker endDateDatePicker;
    @FXML
    ChoiceBox<SettlementType> methodOfSettlement;
    @FXML
    TextField estimationsField;
    @FXML
    CheckBox newCreationCheckBox;
    @FXML
    ChoiceBox<SizeType> sizeChoiceBox;
    @FXML
    CheckBox animatedCheckBox;
    @FXML
    ChoiceBox<ChannelType> communicationChannelChoiceBox;
    @FXML
    ChoiceBox<Client> clientChoiceBox;
    @FXML
    TextArea descriptionField;
    @FXML
    TextArea targetField;
    @FXML
    TextArea creationDescriptionField;
    @FXML
    Label infoLabel;
    @FXML
    Button newClientButton;

    /**
     * Initializes the controller class.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newCreationCheckBox.setSelected(false);
        animatedCheckBox.setSelected(false);

        idField.setText(String.valueOf(UUID.randomUUID()));

        methodOfSettlement.getItems().addAll(EnumSet.allOf(SettlementType.class));
        sizeChoiceBox.getItems().addAll(EnumSet.allOf(SizeType.class));
        communicationChannelChoiceBox.getItems().addAll(EnumSet.allOf(ChannelType.class));
        clientChoiceBox.getItems().addAll(Util.clients);
    }

    /**
     * Toggles the disable property of the creation description field based on the new creation checkbox selection.
     */
    @FXML
    private void setCrationDescriptionFieldEdition() {
        creationDescriptionField.setDisable(!newCreationCheckBox.isSelected());
    }

    /**
     * Closes the current window on cancel button click.
     *
     * @param event The action event triggered by clicking the cancel button.
     */
    @FXML
    private void onCancelButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Handles saving the new campaign data entered by the user.
     *
     * @param event The action event triggered by clicking the save button.
     */
    @FXML
    private void onSaveButtonClick(ActionEvent event) {
        String validationResult = validateInput();
        if (validationResult.equals("true")) {
            Plan plan = new Plan(String.valueOf(UUID.randomUUID()), Integer.parseInt(estimationsField.getText()),
                    targetField.getText(), communicationChannelChoiceBox.getSelectionModel().getSelectedItem(), idField.getText());
            Campaign campaign = new Campaign(idField.getText(), nameField.getText(), new Date(startDateDatePicker.getValue().toEpochDay()),
                    new Date(endDateDatePicker.getValue().toEpochDay()), 0, newCreationCheckBox.isSelected(),
                    sizeChoiceBox.getSelectionModel().getSelectedItem(), animatedCheckBox.isSelected(),
                    (newCreationCheckBox.isSelected() ? creationDescriptionField.getText() : ""), StatusType.PLANNED,
                    methodOfSettlement.getSelectionModel().getSelectedItem(), plan.getId(), clientChoiceBox.getSelectionModel().getSelectedItem().getId(),
                    Util.LOGGED_ON_EMPLOYEE.getId(), "", "", "", descriptionField.getText());

            Util.campaigns.add(campaign);
            Util.plans.add(plan);
            Util.associate();
            onCancelButtonClick(event);
        } else {
            infoLabel.setText(validationResult);
        }
    }

    /**
     * Handles the action when the user wants to add a new client for the campaign.
     */
    @FXML
    private void onNewClientAction() {
        onNewClientSelected();
        showNewClient();
    }

    /**
     * Shows the window for adding a new client to the system.
     */
    private void showNewClient() {
        NCliController.showNewClientWindow(this);
    }

    /**
     * Validates the user input for creating a new campaign.
     *
     * @return A string indicating validation result ("true" for valid input, error message otherwise).
     */
    private String validateInput() {
        if (nameField.getText() == null || nameField.getText().isEmpty()) return "Campaign name is empty.";
        else if (startDateDatePicker.getValue().isBefore(LocalDate.now())) return "Invalid start date.";
        else if (endDateDatePicker.getValue().isBefore(startDateDatePicker.getValue())) return "Invalid end date.";
        else if (methodOfSettlement.getValue() == null) return "Invalid method of settlement.";
        else if (!isInteger(estimationsField.getText())) return "Invalid estimations (should be integer).";
        else if (sizeChoiceBox.getValue() == null) return "Invalid creation size.";
        else if (communicationChannelChoiceBox.getValue() == null) return "Invalid communication channel.";
        else if (clientChoiceBox.getValue() == null) return "Invalid client.";
        else if (descriptionField.getText() == null || descriptionField.getText().isEmpty()) return "Description is required.";
        else if (targetField.getText() == null || targetField.getText().isEmpty()) return "Target description is required.";
        return "true";
    }

    /**
     * Checks if a given string can be parsed into an integer.
     *
     * @param value The string value to check.
     * @return True if the string is a valid integer, false otherwise.
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
     * Disables client choice box and new client button upon selection of new client action.
     */
    private void onNewClientSelected() {
        clientChoiceBox.setDisable(true);
        newClientButton.setDisable(true);
    }

    /**
     * Method called after adding a new client to refresh the client choice box and re-enable new client button.
     */
    public void afterNewClientClose() {
        if (!clientChoiceBox.getItems().isEmpty()) clientChoiceBox.getItems().removeAll(clientChoiceBox.getItems());
        clientChoiceBox.getItems().addAll(Util.clients);
        clientChoiceBox.setDisable(false);
        newClientButton.setDisable(false);
    }

    /**
     * Shows the window for creating a new campaign.
     *
     * @param parent The parent controller initiating the display of the new campaign window.
     */
    public static void showNewCampaign(CPController parent) {
        try {
            FXMLLoader loader = new FXMLLoader(MIController.class.getResource("new-campaign-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("New Campaign");
            stage.show();
            stage.setOnHiding((WindowEvent event) -> parent.afterNewCampaignClose());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
