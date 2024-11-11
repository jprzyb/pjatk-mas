package pl.pjatk.mas.s24512.masproject;

import pl.pjatk.mas.s24512.masproject.Database.Load;
import pl.pjatk.mas.s24512.masproject.Database.Save;
import pl.pjatk.mas.s24512.masproject.Database.Utils;
import pl.pjatk.mas.s24512.masproject.Models.*;
import pl.pjatk.mas.s24512.masproject.Models.enums.RoleType;
import pl.pjatk.mas.s24512.masproject.Models.enums.TeamType;

import java.util.ArrayList;
import java.util.List;

public class Util {

    /**
     * The role type of the currently logged-on user.
     */
    public static RoleType LOGGED_ON_ROLE;

    /**
     * The ID of the currently logged-on user.
     */
    public static Employee LOGGED_ON_EMPLOYEE;

    /**
     * List of communication planners.
     */
    public static List<CommunicationPlanner> communicationPlanners;

    /**
     * List of communication planner managers.
     */
    public static List<CommunicationPlannerManager> communicationPlannerManagers;

    /**
     * List of traffic employees.
     */
    public static List<Traffic> traffics;

    /**
     * List of traffic managers.
     */
    public static List<TrafficManager> trafficManagers;

    /**
     * List of traffic AI employees.
     */
    public static List<TrafficAIO> trafficsAIO;

    /**
     * List of companies.
     */
    public static List<Company> companies;

    /**
     * List of clients.
     */
    public static List<Client> clients;

    /**
     * List of campaigns.
     */
    public static List<Campaign> campaigns;

    /**
     * List of plans.
     */
    public static List<Plan> plans;

    /**
     * List of accountants.
     */
    public static List<Accountant> accountants;

    /**
     * List of designers.
     */
    public static List<Designer> designers;

    /**
     * Loads data from the database into static lists.
     */
    public static void loadData(){
        Utils.setHostName();
        CommunicationPlannerManager.setAnnualBonus(Load.loadAnnualBonusForTeam(TeamType.PLANNERS));
        TrafficManager.setAnnualBonus(Load.loadAnnualBonusForTeam(TeamType.TRAFFICS));
        Price.setPrices(Load.loadPrices());
        EducationLevel.setMap(Load.loadEducationLevels());
        communicationPlanners = Load.loadCommunicationPlanners();
        communicationPlannerManagers = Load.loadCommunicationPlannerManagers();
        traffics = Load.loadTraffics();
        trafficManagers = Load.loadTrafficManagers();
        trafficsAIO = Load.loadTrafficsAIO();
        companies = Load.loadCompanies();
        clients = Load.loadClients();
        plans = Load.loadPlans();
        accountants = Load.loadAccountants();
        designers = Load.loadDesigners();
        campaigns = Load.loadCampaigns();

    }

    public static void associate() {
        // campaigns - planners
        for(Campaign c : campaigns){
            if(c.getPlanner() == null){
                for(CommunicationPlanner p : communicationPlanners){
                    if(c.getPlannerId().equals(p.getId())) {
                        p.getCampaigns().add(c);
                        c.setPlanner(p);
                        break;
                    }
                }
            }
        }
        // campaigns - planner managers
        for(Campaign c : campaigns){
            if(c.getPlanner() == null){
                for(CommunicationPlannerManager p : communicationPlannerManagers){
                    if(c.getPlannerId().equals(p.getId())) {
                        p.getCampaigns().add(c);
                        c.setPlanner(new CommunicationPlanner(p, p.getCampaignsIds(), ""));
                        break;
                    }
                }
            }
        }

        // campaigns - traffics
        for(Campaign c : campaigns){
            if(c.getTrafficId() != null && c.getTraffic() == null){
                for(Traffic t : traffics){
                    if(c.getTrafficId().equals(t.getId())) {
                        t.getCampaigns().add(c);
                        c.setTraffic(t);
                        break;
                    }
                }
            }
        }

        // traffics - traffics AIO

        for(Campaign c : campaigns){
            if(c.getTrafficId() != null && c.getTraffic() == null){
                for(TrafficAIO t : trafficsAIO){
                    if(c.getTrafficId().equals(t.getId())) {
                        t.getCampaigns().add(c);
                        c.setTraffic(new Traffic(t));
                        break;
                    }
                }
            }
        }

        // campaigns - plans
        for(Campaign c : campaigns){
            if(c.getPlanId() != null && c.getPlan() == null){
                for(Plan p : plans){
                    if(c.getPlanId().equals(p.getId())) {
                        p.setCampaign(c);
                        c.setPlan(p);
                        break;
                    }
                }
            }
        }

        // campaigns - clients
        for(Campaign c : campaigns){
            if(c.getClientId() != null && c.getClient() == null){
                for(Client cl : clients){
                    if(c.getClientId().equals(cl.getId())) {
                        c.setClient(cl);
                        break;
                    }
                }
            }
        }

        // campaigns - designers
        for(Campaign c : campaigns){
            if(c.getDesignerId() != null && c.getDesigner() == null){
                for(Designer d : designers){
                    if(c.getDesignerId().equals(d.getId())) {
                        c.setDesigner(d);
                        break;
                    }
                }
            }
        }

        // campaigns - accountants
        for(Campaign c : campaigns){
            if(c.getAccountantId() != null && c.getAccountant() == null){
                for(Accountant a : accountants){
                    if(c.getAccountantId().equals(a.getId())) {
                        c.setAccountant(a);
                        break;
                    }
                }
            }
        }

        // clients - company
        for(Client c : clients){
            if(c.getCompanyId() != null && c.getCompany() == null){
                for(Company co : companies){
                    if(c.getCompanyId().equals(co.getId())){
                        c.setCompany(co);
                        break;
                    }
                }
            }
        }

        // planners - managers
        for(CommunicationPlanner c : communicationPlanners){
            if(c.getManagerId() != null && c.getManager() == null){
                for(CommunicationPlannerManager m : communicationPlannerManagers){
                    if(c.getManagerId().equals(m.getId())){
                        c.setManager(m);
                        m.getSubordinatesIds().add(c.getId());
                        m.getSubordinates().add(c);
                        break;
                    }
                }
            }
        }

        // traffics - traffics managers
        for(Traffic t : traffics){
            if(t.getManagerId() != null && t.getManager() == null){
                for(TrafficManager m : trafficManagers){
                    if(t.getManagerId().equals(m.getId())){
                        t.setManager(m);
                        m.getSubordinatesIds().add(t.getId());
                        m.getSubordinates().add(t);
                        break;
                    }
                }
            }
        }

        // traffics - traffics AIO
        for(Traffic t : traffics){
            if(t.getManagerId() != null && t.getManager() == null){
                for(TrafficAIO m : trafficsAIO){
                    if(t.getManagerId().equals(m.getId())){
                        t.setManager(m);
                        m.getSubordinatesIds().add(t.getId());
                        m.getSubordinates().add(t);
                        break;
                    }
                }
            }
        }
        
    }

    /**
     * Saves data from static lists to the database.
     */
    public static void saveData(){
        Save.saveCommunicationPlanners();
        Save.saveTraffics();
        Save.saveAccountants();
        Save.saveCommunicationPlannerManagers();
        CommunicationPlannerManager.setAnnualBonus(CommunicationPlannerManager.getAnnualBonus());
        Save.saveAnnualBonuses();
        Save.saveCampaigns();
        Save.savePlans();
        Save.saveClients();
        Save.saveCompanies();
        Save.saveDesigners();
        Save.saveTrafficsAIO();
        Save.saveTrafficManagers();
    }
    /**
     * Retrieves a communication planner by ID.
     *
     * @param id The ID of the communication planner.
     * @return The communication planner object, or null if not found.
     */
    public static CommunicationPlanner getCommunicationPlannerById(String id) {
        for (CommunicationPlanner o : communicationPlanners) if(o.getId().equals(id)) return o;
        return null;
    }
    /**
     * Retrieves a communication planner manager by ID.
     *
     * @param id The ID of the communication planner manager.
     * @return The communication planner manager object, or null if not found.
     */
    public static CommunicationPlannerManager getCommunicationPlannerManagerById(String id) {
        for (CommunicationPlannerManager o : communicationPlannerManagers) if(o.getId().equals(id)) return o;
        return null;
    }
    /**
     * Retrieves a traffic employee by ID.
     *
     * @param id The ID of the traffic employee.
     * @return The traffic employee object, or null if not found.
     */
    public static Traffic getTrafficById(String id) {
        for (Traffic o : traffics) if(o.getId().equals(id)) return o;
        return null;
    }
    /**
     * Retrieves a traffic manager by ID.
     *
     * @param id The ID of the traffic manager.
     * @return The traffic manager object, or null if not found.
     */
    public static TrafficManager getTrafficManagerById(String id) {
        for (TrafficManager o : trafficManagers) if(o.getId().equals(id)) return o;
        return null;
    }
    /**
     * Retrieves a traffic AI employee by ID.
     *
     * @param id The ID of the traffic AI employee.
     * @return The traffic AI employee object, or null if not found.
     */
    public static TrafficAIO getTrafficAIOById(String id) {
        for (TrafficAIO o : trafficsAIO) if(o.getId().equals(id)) return o;
        return null;
    }
    /**
     * Retrieves a company by ID.
     *
     * @param id The ID of the company.
     * @return The company object, or null if not found.
     */
    public static Company getCompanyById(String id){
        for(Company o : companies) if(o.getId().equals(id)) return o;
        return null;
    }
    /**
     * Retrieves a client by ID.
     *
     * @param id The ID of the client.
     * @return The client object, or null if not found.
     */
    public static Client getClientById(String id){
        for(Client o : clients) if(o.getId().equals(id)) return o;
        return null;
    }
    /**
     * Retrieves the ID of an employee based on login credentials.
     *
     * @param login The login username of the employee.
     * @return The ID of the employee, or an empty string if not found.
     */
    public static String getEmployeeIdByLogin(String login){
        for(CommunicationPlanner p : communicationPlanners) if(p.getLogin().equals(login)) return p.getId();
        for(CommunicationPlannerManager p : communicationPlannerManagers) if(p.getLogin().equals(login)) return p.getId();
        return "";
    }
    /**
     * Retrieves an employee by ID.
     *
     * @param id The ID of the employee.
     * @return The employee object, or null if not found.
     */
    public static Employee getEmployeeById(String id){
        for(CommunicationPlanner p : communicationPlanners) if(p.getId().equals(id)) return p;
        for(CommunicationPlannerManager p : communicationPlannerManagers) if(p.getId().equals(id)) return p;
        return null;
    }
    /**
     * Retrieves the role type of an employee by ID.
     *
     * @param id The ID of the employee.
     * @return The role type of the employee, or null if not found.
     */
    public static RoleType getRoleById(String id){
        for(CommunicationPlanner p : communicationPlanners){
            if(p.getId().equals(id)) return RoleType.COMMUNICATION_PLANNER;
        }
        for(CommunicationPlannerManager p : communicationPlannerManagers) if(p.getId().equals(id)) return RoleType.COMMUNICATION_PLANNER_MANAGER;
        return null;
    }
    /**
     * Validates login credentials.
     *
     * @param login The login username.
     * @param pass  The password.
     * @return True if the credentials are valid, false otherwise.
     */
    public static boolean validateLogin(String login, String pass){
        for(CommunicationPlanner p : communicationPlanners){
//            System.out.println(p.getLogin() + " " + p.getPassword() + " == " + login + " " + pass);
            if(p.getLogin().equals(login) && p.getPassword().equals(pass)) {
                LOGGED_ON_EMPLOYEE = p;
                return true;
            }
        }
        for(CommunicationPlannerManager p : communicationPlannerManagers){
//            System.out.println(p.getLogin() + " " + p.getPassword() + " == " + login + " " + pass);
            if(p.getLogin().equals(login) && p.getPassword().equals(pass)) {
                LOGGED_ON_EMPLOYEE = p;
                return true;
            }
        }
        return false;
    }
    /**
     * Retrieves a list of campaigns assigned to a communication planner.
     *
     * @param communicationPlanner The ID of the communication planner.
     * @return List of campaigns assigned to the planner.
     */
    public static List<Campaign> getCampaignsByPlanner(CommunicationPlanner communicationPlanner){
        List<Campaign> result = new ArrayList<>();

        for(Campaign c : campaigns) if(c.getPlanner().equals(communicationPlanner)) result.add(c);

        return result;
    }
    /**
     * Retrieves a list of client IDs associated with a company.
     *
     * @param companyId The ID of the company.
     * @return List of client IDs associated with the company.
     */
    public static List<String> getClientsIdsByCompanyId(String companyId){
        List<String> result = new ArrayList<>();

        for(Client c : clients) if(c.getCompanyId().equals(companyId)) result.add(c.getId());

        return result;
    }
    /**
     * Retrieves the manager of a communication planner based on subordinate ID.
     *
     * @param subordinateId The ID of the subordinate communication planner.
     * @return The manager of the subordinate, or null if not found.
     */
    public static CommunicationPlannerManager getManagerBySubordinateId(String subordinateId){
        for(CommunicationPlannerManager c : communicationPlannerManagers) if(c.getSubordinatesIds().contains(subordinateId)) return c;
        return null;
    }
    /**
     * Retrieves a list of communication planners who are subordinates of a manager.
     *
     * @param cpm The communication planner manager.
     * @return List of subordinates of the manager.
     */
    public static List<CommunicationPlanner> getSubordinatesByManager(CommunicationPlannerManager cpm) {
        List<CommunicationPlanner> result = new ArrayList<>();

        for (CommunicationPlanner communicationPlanner : cpm.getSubordinates()) result.add(getCommunicationPlannerById(cpm.getId()));

        return result;
    }
}
