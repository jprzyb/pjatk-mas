import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Worker {
    private final String firstName;
    private final String lastName;
    private static final List<Worker> workers = new ArrayList<>();

    public Map<Integer, Auction> auctions;

    public Worker(String firstName, String lastName){
         this.firstName = firstName;
         this.lastName = lastName;
         auctions = new TreeMap<>();
         workers.add(this);
    }

    public void addAuction(Auction a){
        if(!auctions.containsKey(a.getId())){
            auctions.put(a.getId(), a);
        }
        if(!a.workers.contains(this)){
            a.addWorker(this);
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Worker ").append(firstName).append(" ").append(lastName).append(" takes care of auctions:\n");
        auctions.forEach((key, value) -> res.append("\t- ").append(value).append("\n"));

        return res.toString();
    }

    public Auction findAuctionQualif(int id){
        if(!auctions.containsKey(id)){
            try {
                throw new Exception("Unable to find auction with id: "+id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return auctions.get(id);
    }

    public String workerAsString(){
        return firstName+" "+lastName;
    }
}
