package pl.pjatk.mas.s24512.masproject.Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an TrafficAIO that extends TrafficManager and implements ITraffic interface.
 */
public class TrafficAIO extends TrafficManager implements ITraffic {

    private List<String> campaignIds; // List of campaign IDs managed by this AI-driven Traffic Manager
    private List<Campaign> campaigns; // List of campaign managed by this AI-driven Traffic Manager

    /**
     * Constructs a TrafficAIO object with specified attributes.
     *
     * @param id             The ID of the TrafficAIO
     * @param firstName      The first name of the TrafficAIO
     * @param lastName       The last name of the TrafficAIO
     * @param login          The login username of the TrafficAIO
     * @param password       The login password of the TrafficAIO
     * @param birthDate      The birth date of the TrafficAIO
     * @param employmentDate The date of employment of the TrafficAIO
     * @param salary         The salary of the TrafficAIO
     * @param educationLevel The education level of the TrafficAIO
     * @param subordinatesIds The list of subordinate IDs managed by the TrafficAIO
     * @param campaignIds    The list of campaign IDs managed by the TrafficAIO
     */
    public TrafficAIO(String id, String firstName, String lastName, String login, String password, Date birthDate, Date employmentDate, double salary, EducationLevel educationLevel, List<String> subordinatesIds, List<String> campaignIds) {
        super(id, firstName, lastName, login, password, birthDate, employmentDate, salary, educationLevel, subordinatesIds);
        this.campaignIds = new ArrayList<>();
        this.campaignIds.addAll(campaignIds);
        this.campaigns = new ArrayList<>();
    }

    /**
     * Retrieves the list of campaign IDs managed by this AI-driven Traffic Manager.
     *
     * @return The list of campaign IDs
     */
    public List<String> getCampaignIds() {
        return campaignIds;
    }

    /**
     * Sets the list of campaign IDs managed by this AI-driven Traffic Manager.
     *
     * @param campaignIds The list of campaign IDs to set
     */
    public void setCampaignIds(List<String> campaignIds) {
        this.campaignIds = campaignIds;
    }

    /**
     * Adds a campaign ID to the list managed by this AI-driven Traffic Manager, if not already present.
     *
     * @param campaign campaign to add
     */
    public void addCamaignId(Campaign campaign){
        if(!campaignIds.contains(campaign.getId())) {
            campaignIds.add(campaign.getId());
            campaigns.add(campaign);
        }
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    /**
     * Placeholder method for editing a campaign.
     *
     * @param campaignId The ID of the campaign to edit
     */
    @Override
    public void editCampaign(String campaignId) {
        // Method not implemented
        // No implementation because it's not currently in use
    }
}
