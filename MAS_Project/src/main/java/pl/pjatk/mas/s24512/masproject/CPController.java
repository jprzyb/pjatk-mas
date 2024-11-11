package pl.pjatk.mas.s24512.masproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import pl.pjatk.mas.s24512.masproject.Models.Campaign;
import pl.pjatk.mas.s24512.masproject.Models.CommunicationPlanner;
import pl.pjatk.mas.s24512.masproject.Models.CommunicationPlannerManager;
import pl.pjatk.mas.s24512.masproject.Models.enums.RoleType;

import java.net.URL;
import java.util.ResourceBundle;

public class CPController implements Initializable {
    @FXML
    ListView<Campaign> campaignList;
    @FXML
    Button newCampaignButton;
    @FXML
    Button myInfoButton;

    /**
     * Initializes the controller with initial data when the FXML file is loaded.
     *
     * @param url            The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources used to localize the root object, or null.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadLists();
    }

    /**
     * Shows the new campaign window when the new campaign button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the new campaign button.
     */
    @FXML
    private void showNewCampaign(ActionEvent event) {
        NCController.showNewCampaign(this);
        newCampaignButton.setDisable(true);
    }

    /**
     * Shows the planner's information window when the my information button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the my information button.
     */
    @FXML
    private void showMyInformation(ActionEvent event) {
        MIController.showMyInformation(this);
        myInfoButton.setDisable(true);
    }

    /**
     * Logs out the user when the logout button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the logout button.
     */
    @FXML
    private void logout(ActionEvent event) {
        LoginController.setToLogOffScene(event);
    }

    /**
     * Handles double-click events on the campaign list to show campaign details.
     *
     * @param event The MouseEvent triggered by double-clicking an item in the campaign list.
     */
    @FXML
    private void handleDoubleClick(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
            Campaign selectedItem = campaignList.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                CIController.showCampaignDetailsWindow(selectedItem);
            }
        }
    }

    /**
     * Method called after closing the new campaign window to reload campaign lists and enable new campaign button.
     */
    public void afterNewCampaignClose() {
        loadLists();
        newCampaignButton.setDisable(false);
    }

    /**
     * Method called after closing the my information window to enable my information button.
     */
    public void afterMyInfoClose() {
        myInfoButton.setDisable(false);
    }

    /**
     * Helper method to reload the campaign list with updated data.
     */
    private void loadLists() {
        if(Util.LOGGED_ON_ROLE == RoleType.COMMUNICATION_PLANNER){
            if (campaignList != null) {
                campaignList.getItems().clear();
                for(CommunicationPlanner c : Util.communicationPlanners){
                    if(c.getId().equals(Util.LOGGED_ON_EMPLOYEE.getId())) {
                        campaignList.getItems().addAll(c.getCampaigns());
                    }
                }
            }
        }
        else if(Util.LOGGED_ON_ROLE == RoleType.COMMUNICATION_PLANNER_MANAGER){
            if (campaignList != null) {
                campaignList.getItems().clear();
                for(CommunicationPlannerManager c : Util.communicationPlannerManagers){
                    if(c.getId().equals(Util.LOGGED_ON_EMPLOYEE.getId())) {
                        campaignList.getItems().addAll(c.getCampaigns());
                    }
                }
            }
        }
    }
}
