package BakeryDesign;

public class DecoratorTest {
    public static void main(String[] args) {
        BakeryItem cake = new Cakes();
        System.out.println(cake.getDescription() + " cost: " + cake.cost());

        BakeryItem chocolateCake = new ChocolateTopping(new Cakes());
        System.out.println(chocolateCake.getDescription() + " cost: " + chocolateCake.cost());
    }
}
