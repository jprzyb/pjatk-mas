package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.SettlementType;

import java.util.HashMap;

/**
 * Represents pricing information for different settlement types.
 */
public class Price {

    private static HashMap<SettlementType, Double> prices;

    /**
     * Constructs a Price object with initial pricing information.
     *
     * @param prices A HashMap containing pricing information for different SettlementType
     */
    public Price(HashMap<SettlementType, Double> prices) {
        this.prices = prices;
    }

    /**
     * Retrieves the current prices map.
     *
     * @return The HashMap containing settlement type to price mappings
     */
    public HashMap<SettlementType, Double> getPrices() {
        return prices;
    }

    /**
     * Sets the prices map to the provided HashMap.
     *
     * @param p The HashMap containing settlement type to price mappings to set
     */
    public static void setPrices(HashMap<SettlementType, Double> p) {
        prices = p;
    }

    /**
     * Retrieves the price for the specified settlement type.
     *
     * @param type The SettlementType for which to retrieve the price
     * @return The price associated with the specified SettlementType, or a default value if not found
     */
    public static double getPriceForSettlement(SettlementType type){
        if(prices.containsKey(type)) return prices.get(type);
        return 0.5; // Default value if settlement type not found
    }
}
