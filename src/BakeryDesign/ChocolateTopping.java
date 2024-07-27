package BakeryDesign;

public class ChocolateTopping extends ToppingDecorator {
    public ChocolateTopping(BakeryItem bakeryItem) {
        super(bakeryItem);
    }

    @Override
    public String getDescription() {
        return bakeryItem.getDescription() + ", Chocolate Topping";
    }

    @Override
    public double cost() {
        return bakeryItem.cost() + 5.0;
    }
}
