package BakeryDesign;

public class BakeryTest {
    public static void main(String[] args) {
        Bakery bakery = new Bakery();
        bakery.addObserver(new Customer("Alice"));
        bakery.addObserver(new Customer("Bob"));

        bakery.setCake("Chocolate Cake");
    }
}
