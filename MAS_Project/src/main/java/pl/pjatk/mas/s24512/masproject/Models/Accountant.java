package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.AccountantType;
import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.Date;
import java.util.EnumSet;
import java.util.List;

/**
 * The Accountant class extends the Employee class and represents an accountant in the system.
 * An accountant can be responsible for campaigns or the company, depending on the type.
 */
public class Accountant extends Employee {

    // List of invoices (static, shared among all instances)
    public static List<String> invoices;

    // List of invoices made by the accountant
    public List<String> invoicesMade;

    // List of monthly payments managed by the accountant
    public List<String> monthlyPayment;

    // Type of accountant (can be responsible for campaigns, company, or both)
    private EnumSet<AccountantType> type;

    /**
     * Constructor for the Accountant class.
     *
     * @param id               Accountant's ID
     * @param firstName        Accountant's first name
     * @param lastName         Accountant's last name
     * @param login            Accountant's login
     * @param password         Accountant's password
     * @param birthDate        Accountant's birth date
     * @param employmentDate   Accountant's employment date
     * @param salary           Accountant's salary
     * @param educationLevel   Accountant's education level
     * @param type             Accountant's type (campaign, company, both)
     */
    public Accountant(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, EnumSet<AccountantType> type) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel);
        this.type = type;
    }

    /**
     * Method to calculate an invoice based on the campaign ID.
     *
     * @param campaign invoice Campaign
     */
    public void calcInvoice(Campaign campaign) {
        // Check if the accountant is responsible for campaigns
        if (!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return;
        // Logic for calculating the invoice
    }

    /**
     * Method to calculate the company's income for a specified period.
     *
     * @param start Start date
     * @param stop  End date
     */
    public void calcCorpIncome(Date start, Date stop) {
        if (!type.contains(AccountantType.ACCOUNTANT_COMPANY)) return;
        double result =0.0;

        // Logic for calculating the company's income
        for(Campaign c : Util.campaigns){
            if (c.getEndDate().toLocalDate().isAfter(start.toLocalDate()) && c.getEndDate().toLocalDate().isAfter(stop.toLocalDate())){
//                System.out.println(c + " for " + c.calcCost());
                result += c.calcCost();
            }
        }
        System.out.println(result);
    }

    /**
     * Getter for the list of invoices.
     *
     * @return List of invoices if the accountant is responsible for campaigns; otherwise null
     */
    public List<String> getInvoices() {
        if (!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return null;
        return invoices;
    }

    /**
     * Setter for the list of invoices.
     *
     * @param invoices List of invoices
     */
    public void setInvoices(List<String> invoices) {
        if (!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return;
        Accountant.invoices = invoices;
    }

    /**
     * Getter for the list of invoices made by the accountant.
     *
     * @return List of invoices made by the accountant if responsible for campaigns; otherwise null
     */
    public List<String> getInvoicesMade() {
        if (!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return null;
        return invoicesMade;
    }

    /**
     * Setter for the list of invoices made by the accountant.
     *
     * @param invoicesMade List of invoices made by the accountant
     */
    public void setInvoicesMade(List<String> invoicesMade) {
        if (!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return;
        this.invoicesMade = invoicesMade;
    }

    /**
     * Method to add a new invoice to the list of invoices.
     *
     * @param invoice Invoice to add
     */
    public void addInvoice(String invoice) {
        if (!type.contains(AccountantType.ACCOUNTANT_CAMPAIGN)) return;
        if (!invoices.contains(invoice)) invoices.add(invoice);
    }

    /**
     * Getter for the list of monthly payments.
     *
     * @return List of monthly payments if the accountant is responsible for the company; otherwise null
     */
    public List<String> getMonthlyPayment() {
        if (!type.contains(AccountantType.ACCOUNTANT_COMPANY)) return null;
        return monthlyPayment;
    }

    /**
     * Setter for the list of monthly payments.
     *
     * @param monthlyPayment List of monthly payments
     */
    public void setMonthlyPayment(List<String> monthlyPayment) {
        if (!type.contains(AccountantType.ACCOUNTANT_COMPANY)) return;
        this.monthlyPayment = monthlyPayment;
    }

    /**
     * Getter for the accountant's type.
     *
     * @return Accountant's type
     */
    public EnumSet<AccountantType> getType() {
        return type;
    }

    /**
     * Method to add a new type to the accountant's set of types.
     *
     * @param type Type to add
     */
    public void addType(AccountantType type) {
        if (!this.type.contains(type)) this.type.add(type);
    }

    /**
     * Method to remove a type from the accountant's set of types.
     *
     * @param type Type to remove
     */
    public void removeType(AccountantType type) {
        if (this.type.contains(type)) this.type.remove(type);
    }

    /**
     * Setter for the accountant's set of types.
     *
     * @param type Set of accountant types
     */
    public void setType(EnumSet<AccountantType> type) {
        this.type = type;
    }
}
