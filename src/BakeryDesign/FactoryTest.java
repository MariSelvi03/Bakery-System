package BakeryDesign;

public class FactoryTest {
    public static void main(String[] args) {
        BakeryProductFactory factory = new CakeFactory();
        BakeryProduct product = factory.createProduct();
        product.prepare();
    }
}

