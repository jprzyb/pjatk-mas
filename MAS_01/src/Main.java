public class Main {
    public static void main(String[] args) {
        Book.loadFromFile();
        Book.printAllBooks();



        Book.saveToFile();
//        Book.books.get(1).addReview("Super ksiazka");
//        Book.books.get(1).addReview();
        Book.books.get(0).printAllReviews();
//        Book.books.get(1).printAllReviews();
    }
}