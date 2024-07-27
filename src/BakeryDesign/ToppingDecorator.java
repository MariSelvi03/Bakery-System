package BakeryDesign;

public abstract class ToppingDecorator implements BakeryItem {
    protected BakeryItem bakeryItem;

    public ToppingDecorator(BakeryItem bakeryItem) {
        this.bakeryItem = bakeryItem;
    }
}
