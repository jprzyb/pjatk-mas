package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * The Company class represents a company with attributes such as ID, name, address, account number,
 * regular status, and a list of subordinate IDs.
 */
public class Company {
    private String id; // Unique identifier for the company
    private String name; // Name of the company
    private String address; // Address of the company
    private String accountNumber; // Account number of the company
    private boolean isRegular; // Indicates if the company is a regular client
    private List<String> subordinatesIds; // List of IDs of subordinates associated with the company
    private List<Client> subordinates; // List of IDs of subordinates associated with the company

    /**
     * Constructor for the Company class.
     *
     * @param id               Unique identifier for the company
     * @param name             Name of the company
     * @param address          Address of the company
     * @param accountNumber    Account number of the company
     * @param isRegular        Indicates if the company is a regular client
     * @param subordinatesIds  List of IDs of subordinates associated with the company
     */
    public Company(String id, String name, String address, String accountNumber, boolean isRegular, List<String> subordinatesIds) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.accountNumber = accountNumber;
        this.isRegular = isRegular;
        this.subordinatesIds = new ArrayList<>();
        this.subordinatesIds.addAll(subordinatesIds);
        this.subordinates = new ArrayList<>();
    }

    /**
     * Gets the unique identifier for the company.
     *
     * @return Unique identifier for the company
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the company.
     *
     * @param id Unique identifier for the company
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of the company.
     *
     * @return Name of the company
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the company.
     *
     * @param name Name of the company
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the company.
     *
     * @return Address of the company
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the company.
     *
     * @param address Address of the company
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the account number of the company.
     *
     * @return Account number of the company
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number of the company.
     *
     * @param accountNumber Account number of the company
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Checks if the company is a regular client.
     *
     * @return True if the company is a regular client, otherwise false
     */
    public boolean isRegular() {
        return isRegular;
    }

    /**
     * Sets the regular status of the company.
     *
     * @param regular True if the company is a regular client, otherwise false
     */
    public void setRegular(boolean regular) {
        isRegular = regular;
    }

    /**
     * Gets the list of IDs of subordinates associated with the company.
     *
     * @return List of IDs of subordinates
     */
    public List<String> getSubordinatesIds() {
        return subordinatesIds;
    }

    /**
     * Sets the list of IDs of subordinates associated with the company.
     *
     * @param subordinatesIds List of IDs of subordinates
     */
    public void setSubordinatesIds(List<String> subordinatesIds) {
        this.subordinatesIds = subordinatesIds;
    }

    /**
     * Adds a subordinate to the company's list of subordinates.
     *
     * @param client subordinate to add
     */
    public void addSubordinate(Client client) {
        this.subordinates.add(client);
        client.setCompany(this);
    }

    /**
     * Removes a subordinate from the company's list of subordinates.
     *
     * @param subordinate ID of the subordinate to remove
     */
    public void removeSubordinate(Client subordinate) {
        // Removing from subordinates
        if (subordinates.contains(subordinate)) {
            this.subordinates.remove(subordinate);
        }
    }

    /**
     * Returns the name of the company.
     *
     * @return Name of the company
     */
    @Override
    public String toString() {
        return name;
    }
}
