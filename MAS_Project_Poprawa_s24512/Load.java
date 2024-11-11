package pl.pjatk.mas.s24512.masproject.Database;

import pl.pjatk.mas.s24512.masproject.Models.*;
import pl.pjatk.mas.s24512.masproject.Models.enums.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Load {
    /**
     * Loads CommunicationPlanners from the database.
     * @return List of CommunicationPlanner objects loaded from the database.
     */
    public static List<CommunicationPlanner> loadCommunicationPlanners(){
        List<CommunicationPlanner> result = new ArrayList<>();
        List<String> ids = readIds(Utils.COMMUNICATION_PLANNER_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new CommunicationPlanner(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu),getCampaignsIdsByPlannerId(id), getPlannerManagerIdByPlannerId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Loads CommunicationPlannerManagers from the database.
     * @return List of CommunicationPlannerManager objects loaded from the database.
     */
    public static List<CommunicationPlannerManager> loadCommunicationPlannerManagers(){
        List<CommunicationPlannerManager> result = new ArrayList<>();

        List<String> ids = readIds(Utils.COMMUNICATION_PLANNER_MANAGER_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new CommunicationPlannerManager(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu),getCampaignsIdsByPlannerId(id), getSubordinatesIdByManagerId(id, Utils.COMMUNICATION_PLANNER_TABLE)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }
    /**
     * Loads Traffic employees from the database.
     * @return List of Traffic objects loaded from the database.
     */
    public static List<Traffic> loadTraffics(){
        List<Traffic> result = new ArrayList<>();

        List<String> ids = readIds(Utils.TRAFFIC_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new Traffic(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu),getCampaignsIdsByTrafficId(id), getTrafficManagerIdByTrafficId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Loads TrafficManagers from the database.
     * @return List of TrafficManager objects loaded from the database.
     */
    public static List<TrafficManager> loadTrafficManagers(){
        List<TrafficManager> result = new ArrayList<>();

        List<String> ids = readIds(Utils.TRAFFIC_MANAGER_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new TrafficManager(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu), getSubordinatesIdByManagerId(id, Utils.TRAFFIC_TABLE)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Loads TrafficAIO employees from the database.
     * @return List of TrafficAIO objects loaded from the database.
     */
    public static List<TrafficAIO> loadTrafficsAIO(){
        List<TrafficAIO> result = new ArrayList<>();

        List<String> ids = readIds(Utils.TRAFFIC_AIO_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new TrafficAIO(id, firstName,lastName, login, password, birthDate, employmentDate, salary,
                        new EducationLevel(edu), getSubordinatesIdByManagerId(id, Utils.TRAFFIC_TABLE), getCampaignsIdsByTrafficId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Loads Designers from the database.
     * @return List of Designer objects loaded from the database.
     */
    public static List<Designer> loadDesigners(){
        List<Designer> result = new ArrayList<>();

        List<String> ids = readIds(Utils.DESIGNER_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new Designer(id, firstName,lastName, login, password, birthDate, employmentDate, salary,
                        new EducationLevel(edu), getCampaignsIdsByDesignerId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Loads Accountants from the database.
     * @return List of Accountant objects loaded from the database.
     */
    public static List<Accountant> loadAccountants(){
        List<Accountant> result = new ArrayList<>();

        List<String> ids = new ArrayList<>();

        for(String id : readIds(Utils.ACCOUNTANT_AIO_TABLE)){
            if(!ids.contains(id)) ids.add(id);
        }
        for(String id : readIds(Utils.CAMPAIGN_ACCOUNTANT_TABLE)){
            if(!ids.contains(id)) ids.add(id);
        }
        for(String id : readIds(Utils.COMPANY_ACCOUNTANT_TABLE)){
            if(!ids.contains(id)) ids.add(id);
        }

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                if(isAccountantAIO(id)) {
                    result.add(new Accountant(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu), EnumSet.allOf(AccountantType.class)));
                }
                else if(isAccountantCampaign(id)) {
                    result.add(new Accountant(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu), EnumSet.of(AccountantType.ACCOUNTANT_CAMPAIGN)));
                }
                else if(isAccountantCompany(id)) {
                    result.add(new Accountant(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu), EnumSet.of(AccountantType.ACCOUNTANT_COMPANY)));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Loads Clients from the database.
     * @return List of Client objects loaded from the database.
     */
    public static List<Client> loadClients(){
        List<Client> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CLIENT_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String emailAdress = res.getString("emailAddress");
                String phoneNumber = res.getString("phoneNumber");
                String companyId = res.getString("companyId");
                result.add(new Client(id, firstName, lastName, emailAdress, phoneNumber, companyId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Loads Companies from the database.
     * @return List of Company objects loaded from the database.
     */
    public static List<Company> loadCompanies(){
        List<Company> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.COMPANY_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                String name = res.getString("name");
                String adress = res.getString("address");
                String accountNumber = res.getString("accountNumber");
                boolean isRegular = res.getBoolean("isRegular");
                result.add(new Company(id, name, adress,accountNumber,isRegular, getClientsIdsForCompanyId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Loads Plans from the database.
     * @return List of Plan objects loaded from the database.
     */
    public static List<Plan> loadPlans() {
        List<Plan> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_PLAN_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                int estimatedRate = res.getInt("estimatedRate");
                String target = res.getString("target");
                ChannelType communicationChannel= ChannelType.valueOf(res.getString("communicationChannel"));
                result.add(new Plan(id, estimatedRate, target, communicationChannel, getCampaignIdByPlanId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Loads the annual bonus amount for a specific team type.
     * @param type The type of team to load the bonus for.
     * @return The annual bonus amount for the specified team type.
     */
    public static double loadAnnualBonusForTeam(TeamType type){
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.ANNUAL_BONUS_TABLE + " WHERE team = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(type));

            res = pstmt.executeQuery();

            if (res.next()){
                return res.getDouble("bonus");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0.0;
    }
    /**
     * Loads education levels and their associated factors.
     * @return HashMap containing education levels and their factors.
     */
    public static HashMap<EducationType, Double> loadEducationLevels(){

        HashMap<EducationType, Double> result = new HashMap<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EDUCATION_LEVEL_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String eduLvl = res.getString("level");
                double factor = res.getDouble("factor");
                result.put(EducationType.valueOf(eduLvl), factor);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Loads prices associated with settlement types.
     * @return HashMap containing settlement types and their associated prices.
     */
    public static HashMap<SettlementType, Double> loadPrices(){

        HashMap<SettlementType, Double> result = new HashMap<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.PRICE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String type = res.getString("type");
                double value = res.getDouble("value");
                result.put(SettlementType.valueOf(type), value);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Loads Campaigns from the database.
     * @return List of Campaign objects loaded from the database.
     */
    public static List<Campaign> loadCampaigns() {
        List<Campaign> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                String name = res.getString("name");
                Date startDate = res.getDate("startDate");
                Date endDate = res.getDate("endDate");
                int currentRate = res.getInt("currentRate");
                boolean needsNewCreation = res.getBoolean("needsNewCreation");
                SizeType size = SizeType.valueOf(res.getString("size"));
                boolean isAnimated = res.getBoolean("isAnimated");
                String creationDescription = res.getString("creationDescription");
                StatusType status = StatusType.valueOf(res.getString("status"));
                SettlementType settlementType = SettlementType.valueOf(res.getString("settlement"));
                String plannerId = res.getString("plannerId");
                String trafficId = res.getString("trafficId");
                String clientId = res.getString("clientId");
                String planId = res.getString("planId");
                String designerId = res.getString("designerId");
                String accountantId = res.getString("accountantId");
                String description = res.getString("description");
                Campaign campaign = new Campaign(id, name,startDate, endDate, currentRate, needsNewCreation, size, isAnimated, creationDescription, status, settlementType, planId, clientId, plannerId, trafficId, designerId, accountantId, description);
                result.add(campaign);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
//    ===============================================================================
    /**
     * Retrieves the campaign ID associated with a given plan ID.
     *
     * @param planId The plan ID to search for.
     * @return The campaign ID corresponding to the plan ID, or an empty string if not found.
     */
    private static String getCampaignIdByPlanId(String planId) {
        String result = "";

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE + " WHERE planId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, planId);

            res = pstmt.executeQuery();

            if(res.next()) return res.getString("id");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    /**
     * Retrieves a list of client IDs associated with a given company ID.
     *
     * @param companyId The company ID to search for.
     * @return A list of client IDs belonging to the specified company, or null if an error occurs.
     */
    private static List<String> getClientsIdsForCompanyId(String companyId) {
        List<String> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CLIENT_TABLE + " WHERE companyId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, companyId);

            res = pstmt.executeQuery();

            while(res.next()){
                result.add(res.getString("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Checks if a given accountant ID belongs to any company.
     *
     * @param accountantId The accountant ID to check.
     * @return true if the accountant ID exists in the company accountant table, false otherwise.
     */
    private static boolean isAccountantCompany(String accountantId) {
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT COUNT(*) FROM " + Utils.COMPANY_ACCOUNTANT_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, accountantId);

            res = pstmt.executeQuery();

            if(res.next()) return res.getInt(1) > 0;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Checks if a given accountant ID is associated with any campaign.
     *
     * @param accountantId The accountant ID to check.
     * @return true if the accountant ID exists in the campaign accountant table, false otherwise.
     */
    private static boolean isAccountantCampaign(String accountantId) {
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT COUNT(*) FROM " + Utils.CAMPAIGN_ACCOUNTANT_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, accountantId);

            res = pstmt.executeQuery();

            if(res.next()) return res.getInt(1) > 0;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Checks if a given accountant ID exists in the AIO table.
     *
     * @param accountantId The accountant ID to check.
     * @return true if the accountant ID exists in the AIO table, false otherwise.
     */
    private static boolean isAccountantAIO(String accountantId){
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT COUNT(*) FROM " + Utils.ACCOUNTANT_AIO_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, accountantId);

            res = pstmt.executeQuery();

            if(res.next()) return res.getInt(1) > 0;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Retrieves a list of subordinate IDs managed by a specified manager ID from a given table.
     *
     * @param managerId The manager ID to search for subordinates.
     * @param subordinatesTable The table containing the subordinate information.
     * @return A list of subordinate IDs managed by the specified manager ID, or null if an error occurs.
     */
    private static List<String> getSubordinatesIdByManagerId(String managerId, String subordinatesTable) {
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + subordinatesTable + " WHERE managerId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, managerId);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                result.add(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    /**
     * Retrieves a list of IDs from a specified table.
     *
     * @param tableName The name of the table from which to retrieve IDs.
     * @return A list of IDs retrieved from the specified table.
     */
    private static List<String> readIds(String tableName){
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM "+tableName;
            pstmt = connection.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                String id = res.getString("id");
                result.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Retrieves a list of campaign IDs associated with a planner ID.
     *
     * @param plannerId The planner ID to search for campaigns.
     * @return A list of campaign IDs associated with the specified planner ID, or null if an error occurs.
     */
    private static List<String> getCampaignsIdsByPlannerId(String plannerId){
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE + " WHERE plannerId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, plannerId);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                result.add(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    /**
     * Retrieves a list of campaign IDs associated with a traffic ID.
     *
     * @param trafficId The traffic ID to search for campaigns.
     * @return A list of campaign IDs associated with the specified traffic ID, or null if an error occurs.
     */
    private static List<String> getCampaignsIdsByTrafficId(String trafficId){
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE + " WHERE trafficId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, trafficId);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                result.add(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    /**
     * Retrieves a list of campaign IDs associated with a designer ID.
     *
     * @param trafficId The designer ID to search for campaigns.
     * @return A list of campaign IDs associated with the specified designer ID, or null if an error occurs.
     */
    private static List<String> getCampaignsIdsByDesignerId(String trafficId){
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE + " WHERE designerId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, trafficId);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                result.add(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    /**
     * Retrieves the manager ID associated with a planner ID from the communication planner table.
     *
     * @param plannerId The planner ID to search for.
     * @return The manager ID associated with the specified planner ID, or null if not found.
     */
    private static String getPlannerManagerIdByPlannerId(String plannerId){
        String result = "";

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.COMMUNICATION_PLANNER_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, plannerId);
            res = pstmt.executeQuery();

            if(res.next()) result = res.getString("managerId");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    /**
     * Retrieves the manager ID associated with a traffic ID from the traffic table.
     *
     * @param trafficId The traffic ID to search for.
     * @return The manager ID associated with the specified traffic ID, or null if not found.
     */
    private static String getTrafficManagerIdByTrafficId(String trafficId){
        String result = "";

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.TRAFFIC_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, trafficId);
            res = pstmt.executeQuery();

            if(res.next()) result = res.getString("managerId");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
