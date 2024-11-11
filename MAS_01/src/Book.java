import java.io.*;
import java.util.*;

// Klasa reprezentująca książkę
class Book extends Product implements Serializable {
    // Ekstensja trwała - lista obiektów klasy w klasie
    public static List<Book> books = new ArrayList<>();
    private List<String> reviews = new ArrayList<>(); // Atrybut powtarzalny
    private Author author; // Atrybut złożony
    private String genre;
    private static double vatRate = 0.23; // Atrybut klasowy

    public Book(int id, double price, Author author, String genre) {
        super(id, price);
        this.author = author;
        this.genre = genre;
        books.add(this);
        saveToFile();
    }

    // Metoda klasowa
    public static void printAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public void printAllReviews(){
        loadReviews();
        for(String r : reviews) System.out.println(r);
    }

    // Przesłonięcie
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    // Przeciążenie
    public void addReview() {
        loadReviews();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Napisz recenzję książki:\n");
        String review = scanner.nextLine();
        reviews.add(review);
        saveReviews();
        reviews.clear();
    }
    public void addReview(String review){
        loadReviews();
        reviews.add(review);
        saveReviews();
        reviews.clear();

    }
    public static void saveToFile () {
            String fileName = "books.txt";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                for (Book book : books) {
                    bw.write(book.toString());
                    bw.newLine();
            }
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
    public static void loadFromFile () {
                String fileName = "books.txt";
                List<Book> books = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",");

                        int id = Integer.parseInt(parts[0].split("=")[1].trim());
                        double price = Double.parseDouble(parts[1].split("=")[1].trim().replace("'", ""));
                        String authorName = parts[2].split("=")[2].trim();
                        int authorAge = Integer.parseInt(parts[3].split("=")[1].replace("'", "").replace("}", ""));
                        String genre = parts[4].split("=")[1].trim().replace("'", "").replace("}", "");

                        books.add(new Book(id, price, new Author(authorName, authorAge), genre));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    public void saveReviews(){
        if(!reviews.isEmpty()){
            String fileName = id+".txt";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                bw.flush();
                for (String e : reviews) {
                    bw.write(e);
                    bw.newLine();
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void loadReviews(){
        String fileName = id+".txt";
        checkFile(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                reviews.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkFile(String fileName){
        File file = new File(fileName);
        try{
            if(!file.exists()) file.createNewFile();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    }