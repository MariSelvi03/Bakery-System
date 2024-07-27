package BakeryDesign;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order(100);
        order.setDiscountStrategy(new NoDiscount());
        System.out.println("Final Price: " + order.calculateFinalPrice());
    }
}
