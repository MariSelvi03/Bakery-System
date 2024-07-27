package BakeryDesign;

public class Cakes implements BakeryItem {
    @Override
    public String getDescription() {
        return "Cake";
    }

    @Override
    public double cost() {
        return 20.0;
    }
}
