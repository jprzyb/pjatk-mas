import java.util.ArrayList;
import java.util.List;

public class Owner {
    private final List<Property> propertiesOwned;
    private final String firstName;
    private final String lastName;

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        propertiesOwned = new ArrayList<>();
    }
    public void addProperty(Property property){
        if(!propertiesOwned.contains(property)){
            propertiesOwned.add(property);
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder("Owner:\n");

        if(!propertiesOwned.isEmpty()){
            res.append(firstName).append(" ").append(lastName).append(" own properties:\n").append(getPropertiesAsString());
        }
        else{
            res.append(firstName).append(" ").append(lastName);
        }
        return res.toString();
    }

    private String getPropertiesAsString() {
        StringBuilder res =  new StringBuilder();
        for(Property p : propertiesOwned){
            res.append(" - ").append(p.propertyToString()).append("\n");
        }
        return res.toString();
    }
    public String ownerAsString(){
        return firstName + " " + lastName;
    }
}
