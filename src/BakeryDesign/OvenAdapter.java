package BakeryDesign;

public class OvenAdapter implements BakeryMachine {
    private OldOven oldOven;

    public OvenAdapter(OldOven oldOven) {
        this.oldOven = oldOven;
    }

    @Override
    public void bake() {
        oldOven.oldBakeMethod();
    }
}
