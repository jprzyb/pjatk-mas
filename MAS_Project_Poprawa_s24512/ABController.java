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

import java.net.URL;
import java.util.ResourceBundle;

public class ABController implements Initializable {

    @FXML
    TextField annualBonusField;
    @FXML
    Label infoLabel;

    /**
     * Initializes the controller with initial data when the FXML file is loaded.
     *
     * @param url            The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources used to localize the root object, or null.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        annualBonusField.setText(String.valueOf(CommunicationPlannerManager.getAnnualBonus()));
    }

    /**
     * Shows the annual bonus change window and sets up event handling.
     *
     * @param parent The parent controller from which this method is called.
     */
    public static void showAnnualBonusWindow(CPMController parent) {
        try {
            FXMLLoader loader = new FXMLLoader(ABController.class.getResource("annual-bonus-change.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Annual bonus change");
            stage.show();
            stage.setOnHiding((windowEvent -> parent.afterAnnualBonusChangeClose()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action when the Set button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the Set button.
     */
    @FXML
    private void onSetButtonClick(ActionEvent event) {
        if (isDouble(annualBonusField.getText())) {
            CommunicationPlannerManager.setAnnualBonus(Double.parseDouble(annualBonusField.getText()));
            onCancelButtonClick(event);
        } else {
            infoLabel.setText("Wrong bonus value (should be like 100.99)");
        }
    }

    /**
     * Handles the action when the Cancel button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the Cancel button.
     */
    @FXML
    private void onCancelButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Checks if a given string value can be parsed as a double.
     *
     * @param value The string value to check.
     * @return true if the value can be parsed as a double, false otherwise.
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
