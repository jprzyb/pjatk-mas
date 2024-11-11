public class Adress {
    private final String postalCode;
    private final String city;
    private final String street;
    private final int buildingNumber;
    private final int apartmentNumber;

    public Adress(String postalCode, String city, String street, int buildingNumber) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = -8888;
    }

    public Adress(String postalCode, String city, String street, int buildingNumber, int apartmentNumber) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
    }
    public int getApartmentNumber() {
        return apartmentNumber;
    }
    @Override
    public String toString() {
        if (apartmentNumber == -8888){
            return postalCode+", "+city+", "+street+" "+buildingNumber;
        }
        return postalCode+", "+city+", "+street+" "+buildingNumber+"/"+apartmentNumber;
    }
}
