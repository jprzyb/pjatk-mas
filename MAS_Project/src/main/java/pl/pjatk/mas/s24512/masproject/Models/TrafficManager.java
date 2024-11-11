package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Traffic Manager who manages a team of Traffic employees.
 * Extends the Employee class and provides methods to manage subordinates and set annual bonuses.
 */
public class TrafficManager extends Employee {

    private static double ANNUAL_BONUS; // Static annual bonus for all Traffic Managers
    private List<String> subordinatesIds; // List of subordinate IDs managed by this Traffic Manager
    private List<Traffic> subordinates; // List of subordinates managed by this Traffic Manager

    /**
     * Constructs a TrafficManager object with specified attributes.
     *
     * @param id             The ID of the Traffic Manager
     * @param firstName      The first name of the Traffic Manager
     * @param lastName       The last name of the Traffic Manager
     * @param login          The login username of the Traffic Manager
     * @param password       The login password of the Traffic Manager
     * @param birthDate      The birth date of the Traffic Manager
     * @param employmentDate The date of employment of the Traffic Manager
     * @param salary         The salary of the Traffic Manager
     * @param educationLevel The education level of the Traffic Manager
     * @param subordinatesIds The list of subordinate IDs managed by the Traffic Manager
     */
    public TrafficManager(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> subordinatesIds) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.subordinatesIds = new ArrayList<>();
        this.subordinatesIds.addAll(subordinatesIds);
        this.subordinates = new ArrayList<>();
    }

    /**
     * Retrieves the static annual bonus for all Traffic Managers.
     *
     * @return The annual bonus
     */
    public static double getAnnualBonus() {
        return ANNUAL_BONUS;
    }

    /**
     * Sets the static annual bonus for all Traffic Managers.
     *
     * @param annualBonus The annual bonus to set
     */
    public static void setAnnualBonus(double annualBonus) {
        ANNUAL_BONUS = annualBonus;
    }

    /**
     * Retrieves the list of subordinate IDs managed by this Traffic Manager.
     *
     * @return The list of subordinate IDs
     */
    public List<String> getSubordinatesIds() {
        return subordinatesIds;
    }

    /**
     * Sets the list of subordinate IDs managed by this Traffic Manager.
     *
     * @param subordinatesIds The list of subordinate IDs to set
     */
    public void setSubordinatesIds(List<String> subordinatesIds) {
        this.subordinatesIds = subordinatesIds;
    }

    /**
     * Adds a subordinate to the list managed by this Traffic Manager,
     * setting the manager ID of the subordinate if not already set.
     *
     * @param subordinate subordinate to add
     */
    public void addSubordinate(Traffic subordinate) {
        this.subordinates.add(subordinate);
    }

    /**
     * Removes a subordinate from the list managed by this Traffic Manager,
     * and clears the manager ID of the subordinate.
     *
     * @param subordinate The ID of the subordinate to remove
     */
    public void removeSubordinate(Traffic subordinate) {
        subordinates.remove(subordinate);
        subordinatesIds.remove(subordinate.getId());
        subordinate.setManager(null);
    }

    /**
     * Sets the salary of a subordinate managed by this Traffic Manager.
     *
     * @param subordinate The ID of the subordinate whose salary to set
     * @param salary        The salary to set
     */
    public void setSubordinateSalary(Traffic subordinate, double salary) {
        subordinate.setSalary(salary);
    }

    public List<Traffic> getSubordinates() {
        return subordinates;
    }
}
