package BakeryDesign;

public class BakeryManager {
    private static BakeryManager instance;

    private BakeryManager() {}

    public static BakeryManager getInstance() {
        if (instance == null) {
            instance = new BakeryManager();
        }
        return instance;
    }

    public void manageBakery() {
        System.out.println("Managing the bakery");
    }
}
