package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Util;

/**
 * The Client class represents a client in the system.
 * It contains details about the client's personal and company-related information.
 */
public class Client {
    private String id; // Unique identifier for the client
    private String firstName; // First name of the client
    private String lastName; // Last name of the client
    private String email; // Email address of the client
    private String phoneNumber; // Phone number of the client
    private String companyId; // ID of the company associated with the client

    private Company company; // associated company

    /**
     * Constructor for the Client class.
     *
     * @param id          Unique identifier for the client
     * @param firstName   First name of the client
     * @param lastName    Last name of the client
     * @param email       Email address of the client
     * @param phoneNumber Phone number of the client
     * @param companyId   ID of the company associated with the client
     */
    public Client(String id, String firstName, String lastName, String email, String phoneNumber, String companyId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyId = companyId;
    }

    // Getters and setters for all fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Company getCompany() {
        return company;
    }

    /**
     * Setter for the companyId.
     * Ensures the client is removed from the old company and added to the new company.
     *
     * @param company new company
     */
    public void setCompany(Company company) {
        this.company = company;
        // Set the new company ID
        this.companyId = company.getId();
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
