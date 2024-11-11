package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.EducationType;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * The EducationLevel class represents the education level of an employee.
 */
public class EducationLevel {
    // Static map to store education type and corresponding factors
    private static HashMap<EducationType, Double> map;

    // The education type of the employee
    private EducationType educationType;

    /**
     * Constructor for the EducationLevel class.
     *
     * @param value The education type as a string
     */
    public EducationLevel(String value) {
        try {
            educationType = EducationType.valueOf(value);
        } catch (Exception e) {
            educationType = null;
        }
    }

    /**
     * Sets the static map of education types and their corresponding factors.
     *
     * @param m The map to be set
     */
    public static void setMap(HashMap<EducationType, Double> m) {
        map = m;
    }

    /**
     * Gets the factor associated with the education type.
     *
     * @return The factor for the education type, or 1.0 if the type is not in the map
     */
    public double getFactor() {
        if (!map.containsKey(educationType)) return 1.0;
        return map.get(educationType);
    }

    /**
     * Gets the education type.
     *
     * @return The education type
     */
    public EducationType getEducationType() {
        return educationType;
    }

    /**
     * Sets the education type.
     *
     * @param educationType The education type to be set
     */
    public void setEducationType(EducationType educationType) {
        this.educationType = educationType;
    }
}
