import java.util.ArrayList;
import java.util.List;

public class Building {
    private final Adress adress;
    private final List<Apartment> apartments;

    public Building(Adress adress) {
        this.adress = adress;
        this.apartments = new ArrayList<>();
    }
    private String getAllApartmentsNumbers(){
        StringBuilder s = new StringBuilder();
        for(Apartment a : apartments){
            s.append(a.getApartmentNumber());
            s.append(", ");
        }
        s.delete(s.lastIndexOf(","),s.lastIndexOf(",")+2);
        return s.toString();
    }
    public void addApartment(Apartment apartment){
        if(!apartments.contains(apartment)){
            apartments.add(apartment);
        }
    }
    @Override
    public String toString() {
        return "Building at " + adress + ", have apartments with numbers: " + getAllApartmentsNumbers() + ".";
    }
}
