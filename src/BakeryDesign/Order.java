package BakeryDesign;

public class Order {
    private double price;
    private DiscountStrategy discountStrategy;

    public Order(double price) {
        this.price = price;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalPrice() {
        return discountStrategy.applyDiscount(price);
    }
}
