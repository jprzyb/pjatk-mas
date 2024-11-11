package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.ChannelType;

/**
 * Represents a marketing plan associated with a campaign.
 */
public class Plan {
    private String id;
    private int estimatedRate;
    private String target;
    private ChannelType communicationChannel;
    private String campaignId;
    private Campaign campaign;

    /**
     * Constructs a new Plan object with specified attributes.
     *
     * @param id                  The ID of the plan
     * @param estimatedRate       The estimated rate of the plan
     * @param target              The target audience or goal of the plan
     * @param communicationChannel The communication channel type used in the plan
     * @param campaignId          The ID of the associated campaign
     */
    public Plan(String id, int estimatedRate, String target, ChannelType communicationChannel, String campaignId) {
        this.id = id;
        this.estimatedRate = estimatedRate;
        this.target = target;
        this.communicationChannel = communicationChannel;
        this.campaignId = campaignId;
    }

    public int getEstimatedRate() {
        return estimatedRate;
    }

    public void setEstimatedRate(int estimatedRate) {
        this.estimatedRate = estimatedRate;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public ChannelType getCommunicationChannel() {
        return communicationChannel;
    }

    public void setCommunicationChannel(ChannelType communicationChannel) {
        this.communicationChannel = communicationChannel;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCampaign(Campaign campaign) {
        if(this.campaign != campaign){
            this.campaign = campaign;
            campaign.setPlan(this);
        }
    }
}
