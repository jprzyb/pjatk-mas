package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.StatusType;
import pl.pjatk.mas.s24512.masproject.Models.enums.SizeType;
import pl.pjatk.mas.s24512.masproject.Models.enums.SettlementType;

import java.sql.Date;

/**
 * The Campaign class represents a campaign in the system.
 * It contains details about the campaign's timeline, status, and related entities.
 */
public class Campaign {
    private String id; // Unique identifier for the campaign
    private String name; // Name of the campaign
    private Date startDate; // Start date of the campaign
    private Date endDate; // End date of the campaign
    private int currentRate; // Current rate of the campaign
    private boolean needsNewCreation; // Flag indicating if new creation is needed
    private SizeType size; // Size of the campaign
    private boolean isAnimated; // Flag indicating if the campaign is animated
    private String creationDesc; // Description of the creation process
    private StatusType status; // Status of the campaign
    private SettlementType settlement; // Settlement type of the campaign
    private String planId; // ID of the associated plan
    private String clientId; // ID of the client
    private String plannerId; // ID of the planner
    private String trafficId; // ID of the traffic
    private String designerId; // ID of the designer
    private String accountantId; // ID of the accountant
    private String description; // Additional description of the campaign

    private Plan plan; // associated plan
    private Client client; // associated client
    private CommunicationPlanner planner; // associated planner
    private Traffic traffic; // associated traffic
    private Designer designer; // associated designer
    private Accountant accountant; // associated accountant

    /**
     * Constructor for the Campaign class.
     *
     * @param id               Unique identifier for the campaign
     * @param name             Name of the campaign
     * @param startDate        Start date of the campaign
     * @param endDate          End date of the campaign
     * @param currentRate      Current rate of the campaign
     * @param needsNewCreation Flag indicating if new creation is needed
     * @param size             Size of the campaign
     * @param isAnimated       Flag indicating if the campaign is animated
     * @param creationDesc     Description of the creation process
     * @param status           Status of the campaign
     * @param settlement       Settlement type of the campaign
     * @param planId           ID of the associated plan
     * @param clientId         ID of the client
     * @param plannerId        ID of the planner
     * @param trafficId        ID of the traffic manager
     * @param designerId       ID of the designer
     * @param accountantId     ID of the accountant
     * @param description      Additional description of the campaign
     */
    public Campaign(String id, String name, Date startDate, Date endDate, int currentRate,
                    boolean needsNewCreation, SizeType size, boolean isAnimated, String creationDesc, StatusType status,
                    SettlementType settlement, String planId, String clientId, String plannerId, String trafficId, String designerId, String accountantId, String description) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentRate = currentRate;
        this.needsNewCreation = needsNewCreation;
        this.size = size;
        this.isAnimated = isAnimated;
        this.creationDesc = creationDesc;
        this.status = status;
        this.settlement = settlement;
        this.description = description;

        this.planId = planId;
        this.clientId = clientId;
        this.plannerId = plannerId;
        this.trafficId = trafficId;
        this.designerId = designerId;
        this.accountantId = accountantId;
    }

    // Getters and setters for all fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(int currentRate) {
        this.currentRate = currentRate;
    }

    public boolean isNeedsNewCreation() {
        return needsNewCreation;
    }

    public void setNeedsNewCreation(boolean needsNewCreation) {
        this.needsNewCreation = needsNewCreation;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    public String getCreationDesc() {
        return creationDesc;
    }

    public void setCreationDesc(String creationDesc) {
        this.creationDesc = creationDesc;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public SettlementType getSettlement() {
        return settlement;
    }

    public void setSettlement(SettlementType settlement) {
        this.settlement = settlement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
        plan.setCampaign(this);

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CommunicationPlanner getPlanner() {
        return planner;
    }

    public void setPlanner(CommunicationPlanner planner) {
                if(this.planner != null) this.planner.getCampaigns().remove(this);
                this.planner = planner;
                this.plannerId = planner.getId();
                planner.addCampaign(this);
    }

    public Traffic getTraffic() {
        return traffic;
    }

    public void setTraffic(Traffic traffic) {
        if(!this.traffic.equals(traffic) ){
            this.traffic.getCampaigns().remove(this);
            this.traffic = traffic;
            traffic.getCampaigns().add(this);
        }
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        if(!this.designer.equals(designer) ){
            this.designer.getCampaigns().remove(this);
            this.designer = designer;
            designer.getCampaigns().add(this);
        }
    }

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(String plannerId) {
        this.plannerId = plannerId;
    }

    public String getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(String trafficId) {
        this.trafficId = trafficId;
    }

    public String getDesignerId() {
        return designerId;
    }

    public void setDesignerId(String designerId) {
        this.designerId = designerId;
    }

    public String getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(String accountantId) {
        this.accountantId = accountantId;
    }

    /**
     * Method to calculate the cost of the campaign based on the current rate and settlement type.
     * If type is CPM it divides result by 1000.
     *
     * @return Calculated cost of the campaign
     */
    public double calcCost() {
        double result = currentRate * Price.getPriceForSettlement(settlement);
        if(settlement.equals(SettlementType.CPM)) result /= 1000;
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
