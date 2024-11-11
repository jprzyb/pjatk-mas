package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The Designer class represents a designer employee with specific attributes such as a list of campaign IDs.
 */
public class Designer extends Employee {

    // List of campaign IDs the designer is associated with
    List<String> campaignsId;
    List<Campaign> campaigns;

    /**
     * Constructor for the Designer class.
     *
     * @param id              Unique identifier for the designer
     * @param firstName       First name of the designer
     * @param lastName        Last name of the designer
     * @param login           Login username for the designer
     * @param password        Password for the designer
     * @param birthDate       Birth date of the designer
     * @param employmentDate  Employment date of the designer
     * @param salary          Salary of the designer
     * @param educationLevel  Education level of the designer
     * @param campaignsId     List of campaign IDs the designer is associated with
     */
    public Designer(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> campaignsId) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.campaignsId = new ArrayList<>();
        this.campaignsId.addAll(campaignsId);
        this.campaigns = new ArrayList<>();
    }

    /**
     * Method to create a new creation for a specific campaign.
     *
     * @param campaign campaign for which a new creation is to be made
     */
    public void makeCreation(Campaign campaign) {
        campaign.setNeedsNewCreation(false);
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }
}
