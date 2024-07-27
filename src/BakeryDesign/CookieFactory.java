package BakeryDesign;

public class CookieFactory extends BakeryProductFactory {

    @Override
    public BakeryProduct createProduct() {
        return new Cookie();
    }
}

