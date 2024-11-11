import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Inicjacja
        Building building1 = new Building(new Adress("03-813","Warsaw","Terespolska",3));
        Building building2 = new Building(new Adress("01-111","Warsaw","Zlota",41));
        Apartment apartment1 = Apartment.createApartament(building1, new Adress("03-813","Warsaw","Terespolska",3,393));
        Apartment apartment2 = Apartment.createApartament(building1, new Adress("03-813","Warsaw","Terespolska",3,394));
        Apartment apartment3 = Apartment.createApartament(building2, new Adress("01-111","Warsaw","Zlota",41,1));
        Apartment apartment4 = Apartment.createApartament(building2, new Adress("01-111","Warsaw","Zlota",41,2));
        Owner owner1 = new Owner("Jacek","Placek");
        Owner owner2 = new Owner("Krzysiek","Pysiek");
        Property property1 = new Property(1,1000000,apartment1, owner1);
        Property property2 = new Property(2, 2000000,apartment1, owner2);
        Property property3 = new Property(3, 1500000,apartment1, owner2);
        Property property4 = new Property(4, 900000,apartment2, owner2);
        Client client1 = new Client("Worek", "Pieniedzy");
        Client client2 = new Client("Worek", "Kasy");
        Auction auction1 = new Auction(property1, new Date(), property1.getPrice(), 1);
        Auction auction2 = new Auction(property2, new Date(), property2.getPrice(),2);
        Auction auction3 = new Auction(property3, new Date(), property3.getPrice(),3);

        // Association: Client *-* Auction (can exist without each other but can be asociated)
        System.out.println("\n=============== Asocjacja ===============");
        client1.addAuction(auction1); // client is automaticaly added to auction clients
        System.out.println(client1);
        System.out.println(auction1);

        client2.addAuction(auction2); // auction is automaticaly added to client auctions
        client2.addAuction(auction3); // auction is automaticaly added to client auctions
        System.out.println(client2);
        System.out.println(auction2);
        System.out.println(auction3);

//         Association with attribute: Owner 1-(Property)-* Apartment
//        !!!!!!!!!!!!!WRONG IT NEEDS TO BE *-*
//        fixed :D now properties can have many owners
//         Association with attribute: Owner *-1(Property)1-* Apartment
        System.out.println("\n=============== Asocjacja z atrybutem ===============");
        owner1.addProperty(property1);
        owner1.addProperty(property2);
        owner1.addProperty(property3);
        System.out.println(owner1);
        System.out.println(property1);
        System.out.println(property2);
        System.out.println(property3);
        System.out.println(property4);
        System.out.println("Apartment1 properties: "+apartment1.getProperties());
        System.out.println("Apartment2 properties: "+apartment2.getProperties());
        System.out.println("Apartment3 properties: "+apartment3.getProperties());
        System.out.println("Apartment4 properties: "+apartment4.getProperties());

//        // Qualified association:
        System.out.println("\n=============== Asocjacja kwalifikowana ===============");
        Worker worker1 = new Worker("Oddany", "Pracownik");
        worker1.addAuction(auction1);
        worker1.addAuction(auction2);
        System.out.println(auction1.auctionWorkersToString());
        System.out.println(auction2.auctionWorkersToString());
        System.out.println(worker1);
        System.out.println("FindAuctionQualif(1):\n" + worker1.findAuctionQualif(1));
        System.out.println("FindAuctionQualif(2):\n" + worker1.findAuctionQualif(2));
//        System.out.println("FindAuctionQualif(100):\n" + worker1.findAuctionQualif(100));

//        // Composition: Building 1-* Apartments
        System.out.println("\n=============== Kompozycja ===============");
        System.out.println("Buildings:");
        System.out.println(building1);
        System.out.println(building2);
        System.out.println();
        apartment1.showApartmentBuilding();
        System.out.println();
        apartment2.showApartmentBuilding();
        System.out.println();
        apartment3.showApartmentBuilding();
        System.out.println();
        apartment4.showApartmentBuilding();
    }
}