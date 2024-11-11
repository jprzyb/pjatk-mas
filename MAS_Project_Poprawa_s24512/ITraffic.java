package pl.pjatk.mas.s24512.masproject.Models;

/**
 * The ITraffic interface represents traffic management functionality for campaigns.
 */
public interface ITraffic {

    /**
     * Edits the campaign identified by the given campaign ID.
     *
     * @param campaignId The ID of the campaign to edit
     */
    public void editCampaign(String campaignId);
}
