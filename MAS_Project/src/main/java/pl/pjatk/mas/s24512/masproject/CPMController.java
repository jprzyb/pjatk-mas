package pl.pjatk.mas.s24512.masproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pl.pjatk.mas.s24512.masproject.Models.CommunicationPlanner;
import pl.pjatk.mas.s24512.masproject.Models.CommunicationPlannerManager;
import pl.pjatk.mas.s24512.masproject.Models.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class CPMController extends CPController implements Initializable {
    @FXML
    ListView<CommunicationPlanner> subordinates;
    @FXML
    Button setSalaryButton;
    @FXML
    Button setAnnualBonusButton;

    /**
     * Initializes the controller with initial data when the FXML file is loaded.
     *
     * @param url            The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources used to localize the root object, or null.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        loadEmployeeList();
    }

    /**
     * Shows the annual bonus view window when the set annual bonus button is clicked.
     */
    @FXML
    private void showAnnualBonusView() {
        setAnnualBonusButton.setDisable(true);
        ABController.showAnnualBonusWindow(this);
    }

    /**
     * Sets the salary for the selected employee when the set salary button is clicked.
     */
    @FXML
    private void setEmployeeSalary() {
        CommunicationPlanner selectedPlanner = subordinates.getSelectionModel().getSelectedItem();
        if (selectedPlanner != null) {
            setSalaryButton.setDisable(true);
            ESController.showEmployeeSalaryWindow(selectedPlanner, this);
        }
    }

    /**
     * Loads the list of subordinates managed by the logged-in communication planner.
     */
    private void loadEmployeeList() {
        if (subordinates != null) {
            subordinates.getItems().clear();
            for(CommunicationPlannerManager c : Util.communicationPlannerManagers){
                if(c.getId() == Util.LOGGED_ON_EMPLOYEE.getId()) subordinates.getItems().addAll(c.getSubordinates());
            }
        }
    }

    /**
     * Method called after closing the employee salary change window to reload employee list and enable set salary button.
     */
    public void afterEmployeeSalaryChangeClose() {
        loadEmployeeList();
        setSalaryButton.setDisable(false);
    }

    /**
     * Method called after closing the annual bonus change window to enable set annual bonus button.
     */
    public void afterAnnualBonusChangeClose() {
        setAnnualBonusButton.setDisable(false);
    }
}
