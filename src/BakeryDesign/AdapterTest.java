package BakeryDesign;

public class AdapterTest {
    public static void main(String[] args) {
        OldOven oldOven = new OldOven();
        BakeryMachine machine = new OvenAdapter(oldOven);
        machine.bake();
    }
}
