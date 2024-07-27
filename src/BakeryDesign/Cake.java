package BakeryDesign;
public class Cake implements BakeryProduct {
    @Override
    public void prepare() {
        System.out.println("Preparing Cake");
    }
}
