package pl.pjatk.mas.s24512.masproject.Models;

import java.sql.Date;
import java.time.LocalDate;

/**
 * The Employee class represents an abstract base class for all types of employees.
 */
public abstract class Employee {
    // Employee ID
    private String id;

    // Employee first name
    private String firstName;

    // Employee last name
    private String lastName;

    // Employee login credential
    private String login;

    // Employee password
    private String password;

    // Employee birth date
    private Date birthDate;

    // Employee employment date
    private Date employmentDate;

    // Employee base salary
    private double salary;

    // Employee education level
    private EducationLevel educationLevel;

    /**
     * Constructor for the Employee class.
     *
     * @param id The employee's ID
     * @param firstName The employee's first name
     * @param lastName The employee's last name
     * @param login The employee's login
     * @param password The employee's password
     * @param birthDate The employee's birth date
     * @param employmentDate The employee's employment date
     * @param salary The employee's salary
     * @param educationLevel The employee's education level
     */
    public Employee(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.educationLevel = educationLevel;
    }

    /**
     * Gets the employee ID.
     *
     * @return The employee ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the employee ID.
     *
     * @param id The new employee ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the employee's first name.
     *
     * @return The employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the employee's first name.
     *
     * @param firstName The new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the employee's last name.
     *
     * @return The employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the employee's last name.
     *
     * @param lastName The new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the employee's login.
     *
     * @return The employee's login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the employee's login.
     *
     * @param login The new login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the employee's password.
     *
     * @return The employee's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the employee's password.
     *
     * @param password The new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the employee's birth date.
     *
     * @return The employee's birth date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the employee's birth date.
     *
     * @param birthDate The new birth date
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the employee's employment date.
     *
     * @return The employee's employment date
     */
    public Date getEmploymentDate() {
        return employmentDate;
    }

    /**
     * Sets the employee's employment date.
     *
     * @param employmentDate The new employment date
     */
    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    /**
     * Gets the employee's base salary.
     *
     * @return The employee's base salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the employee's base salary.
     *
     * @param salary The new base salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Gets the final salary of the employee, which is adjusted by their education level.
     *
     * @return The final salary
     */
    public double getFinalSalary() {
        return salary * educationLevel.getFactor();
    }

    /**
     * Gets the employee's education level.
     *
     * @return The employee's education level
     */
    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    /**
     * Sets the employee's education level.
     *
     * @param educationLevel The new education level
     */
    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * Calculates the age of the employee based on their birth date.
     *
     * @return The employee's age
     */
    public int calcAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    /**
     * Calculates the seniority of the employee based on their employment date.
     *
     * @return The employee's seniority
     */
    public int calcSeniority() {
        return LocalDate.now().getYear() - employmentDate.getYear();
    }

    /**
     * Returns a string representation of the employee, which is their first name and last name.
     *
     * @return The string representation of the employee
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
