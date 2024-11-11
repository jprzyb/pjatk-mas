import java.util.ArrayList;
import java.util.List;

public class Property{
    private final double price;
    private Owner owner;
    private Apartment apartment;
    int id;

    public Property(int id, double price, Apartment apartment, Owner owner) {
        this.id = id;
        this.price = price;
        this.apartment = apartment;
        this.apartment.addProperties(this);
        this.owner = owner;
        this.owner.addProperty(this);
    }

    @Override
    public String toString(){
        return "Property:\nid: "+id+" |  worth "+price +", owner: "+owner.ownerAsString();
    }

    public String propertyToString(){
        return "id: "+id+" is worth "+price;
    }
    public int getId(){
        return this.id;
    }
    public double getPrice(){
        return this.price;
    }
}
