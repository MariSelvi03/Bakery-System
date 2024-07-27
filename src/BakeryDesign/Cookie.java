package BakeryDesign;

public class Cookie implements BakeryProduct {

    @Override
    public void prepare() {
        System.out.println("Preparing Cookie");
    }
}
