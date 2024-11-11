import java.util.ArrayList;
import java.util.List;

public class Client {

    private final List<Auction> auctions;
    private final String firstName;
    private final String lastName;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        auctions = new ArrayList<>();
    }
    public void addAuction(Auction a){
        if(!auctions.contains(a)){
            auctions.add(a);
            a.addClient(this);
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Client:\n");
        if(!auctions.isEmpty()){
            res.append(firstName).append(" ").append(lastName).append(" is interested in auctions:\n").append(getAuctionsAsString());
        }
        else{
            res.append("Client ").append(firstName).append(" ").append(lastName);
        }
        return res.toString();
    }
    private String getAuctionsAsString(){
        StringBuilder res = new StringBuilder("");
        for(Auction a : auctions){
            res.append(" - ").append(a.auctionToString()).append("\n");
        }
        return res.toString();
    }

    public String clientToString(){
        return "Client " + firstName+ " "+lastName;
    }
}
