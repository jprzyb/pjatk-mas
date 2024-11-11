package pl.pjatk.mas.s24512.masproject.Database;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Utils {

    /**
     * JDBC URL for connecting to the SQL Server database.
     */
    public static String URL = "jdbc:sqlserver://{hostname};trustServerCertificate=true";

    /**
     * Username for connecting to the SQL Server database.
     */
    public static final String USR = "MAS";

    /**
     * Password for connecting to the SQL Server database.
     */
    public static final String PASS = "MAS";

    /**
     * JDBC driver class name for SQL Server.
     */
    public static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    /**
     * Table name for AccountantAIO.
     */
    public static final String ACCOUNTANT_AIO_TABLE = "AccountantAIO";

    /**
     * Table name for AnnualBonus.
     */
    public static final String ANNUAL_BONUS_TABLE = "AnnualBonus";

    /**
     * Table name for Campaign.
     */
    public static final String CAMPAIGN_TABLE = "Campaign";

    /**
     * Table name for CampaignAccountant.
     */
    public static final String CAMPAIGN_ACCOUNTANT_TABLE = "CampaignAccountant";

    /**
     * Table name for CampaignPlan.
     */
    public static final String CAMPAIGN_PLAN_TABLE = "CampaignPlan";

    /**
     * Table name for Client.
     */
    public static final String CLIENT_TABLE = "Client";

    /**
     * Table name for CommunicationPlanner.
     */
    public static final String COMMUNICATION_PLANNER_TABLE = "CommunicationPlanner";

    /**
     * Table name for Company.
     */
    public static final String COMPANY_TABLE = "Company";

    /**
     * Table name for CompanyAccountant.
     */
    public static final String COMPANY_ACCOUNTANT_TABLE = "CompanyAccountant";

    /**
     * Table name for Designer.
     */
    public static final String DESIGNER_TABLE = "Designer";

    /**
     * Table name for EducationLevel.
     */
    public static final String EDUCATION_LEVEL_TABLE = "EducationLevel";

    /**
     * Table name for Employee.
     */
    public static final String EMPLOYEE_TABLE = "Employee";

    /**
     * Table name for PlannerManager.
     */
    public static final String COMMUNICATION_PLANNER_MANAGER_TABLE = "PlannerManager";

    /**
     * Table name for Price.
     */
    public static final String PRICE_TABLE = "Price";

    /**
     * Table name for Traffic.
     */
    public static final String TRAFFIC_TABLE = "Traffic";

    /**
     * Table name for TrafficAIO.
     */
    public static final String TRAFFIC_AIO_TABLE = "TrafficAIO";

    /**
     * Table name for TrafficManager.
     */
    public static final String TRAFFIC_MANAGER_TABLE = "TrafficManager";

    public static void setHostName(){
        try {
            URL = URL.replace("{hostname}", InetAddress.getLocalHost().getHostName());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
