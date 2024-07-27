package BakeryDesign;

public class BakeryManagerTest {
    public static void main(String[] args) {
        BakeryManager manager1 = BakeryManager.getInstance();
        BakeryManager manager2 = BakeryManager.getInstance();

        manager1.manageBakery();

        if (manager1 == manager2) {
            System.out.println("Both instances are the same");
        }
    }
}
