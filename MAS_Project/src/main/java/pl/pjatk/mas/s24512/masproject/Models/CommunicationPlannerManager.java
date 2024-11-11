package pl.pjatk.mas.s24512.masproject.Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The CommunicationPlannerManager class represents a manager overseeing communication planners.
 * It extends the Employee class and adds specific attributes and methods for managing campaigns and subordinates.
 */
public class CommunicationPlannerManager extends Employee {
    private static double ANNUAL_BONUS; // Annual bonus for the manager
    private List<String> campaignsIds; // List of campaign IDs managed by the manager
    private List<Campaign> campaigns; // List of campaign managed by the manager
    private List<String> subordinatesIds; // List of IDs of subordinates managed by the manager
    private List<CommunicationPlanner> subordinates; // List of subordinates managed by the manager

    /**
     * Constructor for the CommunicationPlannerManager class.
     *
     * @param id               Unique identifier for the manager
     * @param firstName        First name of the manager
     * @param lastName         Last name of the manager
     * @param login            Login username of the manager
     * @param password         Password of the manager
     * @param birthDate        Birth date of the manager
     * @param employmentDate   Employment date of the manager
     * @param salary           Salary of the manager
     * @param educationLevel   Education level of the manager
     * @param campaignsIds     List of campaign IDs managed by the manager
     * @param subordinatesIds  List of IDs of subordinates managed by the manager
     */
    public CommunicationPlannerManager(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> campaignsIds, List<String> subordinatesIds) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.campaignsIds = new ArrayList<>();
        this.campaignsIds.addAll(campaignsIds);
        this.subordinatesIds = new ArrayList<>();
        this.subordinatesIds.addAll(subordinatesIds);
        this.campaigns = new ArrayList<>();
        this.subordinates = new ArrayList<>();
    }

    /**
     * Constructor for the CommunicationPlannerManager class using a CommunicationPlanner object.
     *
     * @param cp               CommunicationPlanner object
     * @param subordinatesIds  List of IDs of subordinates managed by the manager
     */
    public CommunicationPlannerManager(CommunicationPlanner cp, List<String> subordinatesIds) {
        super(cp.getId(), cp.getFirstName(), cp.getLastName(), cp.getLogin(), cp.getPassword(), cp.getBirthDate(), cp.getEmploymentDate(), cp.getSalary(), cp.getEducationLevel());
        this.campaignsIds = new ArrayList<>();
        this.campaignsIds.addAll(cp.getCampaignsIds());
        this.subordinatesIds = new ArrayList<>();
        this.subordinatesIds.addAll(subordinatesIds);
    }

    /**
     * Sets the annual bonus for the manager.
     *
     * @param annualBonus Annual bonus amount
     */
    public static void setAnnualBonus(double annualBonus) {
        ANNUAL_BONUS = annualBonus;
//        System.out.println("CPM 64 " + ANNUAL_BONUS);
    }

    /**
     * Gets the annual bonus for the manager.
     *
     * @return Annual bonus amount
     */
    public static double getAnnualBonus() {
        return ANNUAL_BONUS;
    }

    /**
     * Gets the list of campaign IDs managed by the manager.
     *
     * @return List of campaign IDs
     */
    public List<String> getCampaignsIds() {
        return campaignsIds;
    }

    /**
     * Sets the list of campaign IDs managed by the manager.
     *
     * @param campaignsIds List of campaign IDs
     */
    public void setCampaignsIds(List<String> campaignsIds) {
        this.campaignsIds = campaignsIds;
    }

    /**
     * Gets the list of IDs of subordinates managed by the manager.
     *
     * @return List of IDs of subordinates
     */
    public List<String> getSubordinatesIds() {
        return subordinatesIds;
    }

    /**
     * Sets the list of IDs of subordinates managed by the manager.
     *
     * @param subordinatesIds List of IDs of subordinates
     */
    public void setSubordinatesIds(List<String> subordinatesIds) {
        this.subordinatesIds = subordinatesIds;
    }

    /**
     * Removes a subordinate from the manager's list of subordinates.
     *
     * @param subordinateId ID of the subordinate to remove
     */
    public void removeSubordinate(String subordinateId) {
        if (subordinatesIds.contains(subordinateId)) {
            subordinatesIds.remove(subordinateId);
        }
    }

    /**
     * Adds a subordinate to the manager's list of subordinates.
     * Also ensures the subordinate's manager ID is set correctly.
     *
     * @param communicationPlanner subordinate to add
     */
    public void addSubordinate(CommunicationPlanner communicationPlanner) {
        if (!subordinates.contains(communicationPlanner)) {
            communicationPlanner.setManager(this);
            subordinates.add(communicationPlanner);
        }
    }

    /**
     * Sets the salary of a subordinate.
     *
     * @param communicationPlanner  subordinate
     * @param salary        New salary amount
     */
    public void setSubordinateSalary(CommunicationPlanner communicationPlanner, double salary) {
        communicationPlanner.setSalary(salary);
    }

    public List<CommunicationPlanner> getSubordinates() {
        return subordinates;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public void setSubordinates(List<CommunicationPlanner> subordinates) {
        this.subordinates = subordinates;
    }

}
