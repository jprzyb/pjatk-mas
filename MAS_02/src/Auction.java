import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Auction {
    private final Date date;
    private final int id;
    private final Property property;
    private final double actualPrice;
    private final List<Client> clients;
    public final List<Worker> workers;
    public Auction(Property property, Date date, double actualPrice, int id) {
        this.date = date;
        this.id = id;
        this.property = property;
        this.actualPrice = actualPrice;
        clients = new ArrayList<>();
        workers = new ArrayList<>();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder("Auction:\n");
        if(!clients.isEmpty()){
            res.append("Property ").append(property).append(" is on sale for ").append(actualPrice)
                    .append(" at ").append(date)
                    .append("\nClients interested in:\n").append(clientsToString());
        }
        else{
            res.append("Property ").append(property).append(" is on sale for ").append(actualPrice)
                    .append(" at ").append(date);
        }


        return res.toString();
    }

    public int getId() {
        return id;
    }

    public Property getProperty() {
        return property;
    }
    public void addWorker(Worker worker){
        if(!workers.contains(worker)){
            workers.add(worker);
        }
        if(!worker.auctions.containsKey(this.getId())){
            worker.addAuction(this);
        }
    }

    public void addClient(Client client){
        if(!clients.contains(client)){
            clients.add(client);
            client.addAuction(this);
        }
    }
    private String clientsToString(){
        StringBuilder res = new StringBuilder();

        for(Client c : clients){
            res.append(c.clientToString()).append("\n");
        }

        return res.toString();
    }
    public String auctionToString(){
        return "Auction: " + "Property " + property + " is on sale for " + actualPrice +
                " at " + date;
    }
    public String auctionWorkersToString(){
        StringBuilder res = new StringBuilder("Workers:\n");
        for(Worker worker : workers){
            res.append(" - ").append(worker.workerAsString()).append("\n");
        }

        return res.toString();
    }
}
