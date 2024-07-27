package BakeryDesign;

public class CakeFactory extends BakeryProductFactory {
    @Override
    public BakeryProduct createProduct() {
        return new Cake();
    }
}
