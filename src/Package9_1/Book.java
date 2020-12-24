package Package9_1;

public class Book {
    String bid ;
    String name;
    String price;

    public Book(String bid, String name, String price) {
        this.bid = bid;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
