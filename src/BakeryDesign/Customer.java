package BakeryDesign;

public class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String cakeName) {
        System.out.println(name + " has been notified of the new cake: " + cakeName);
    }
}
