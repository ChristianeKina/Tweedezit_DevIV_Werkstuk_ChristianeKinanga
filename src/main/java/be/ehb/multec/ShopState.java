package be.ehb.multec;

public class ShopState extends ShoppingCartState{

    public ShopState(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public void pay(){
        throw new IllegalStateException("You can't pay when you're in the shop state");
    }

    @Override
    public void cancel() {
        throw new IllegalStateException("You can't cancel when you're in the cancel state");
    }
}
