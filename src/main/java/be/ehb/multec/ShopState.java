package be.ehb.multec;

public class ShopState extends ShoppingCartState{

    public ShopState(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public void pay(){
        throw new IllegalStateException("YOU CANNOT PAY WHILE YOU'RE IN THE SHOP STATE RAFAEL!!!");
    }

    @Override
    public void cancel() {
        throw new IllegalStateException("YOU CANNOT CANCEL WHILE YOU'RE IN THE SHOP STATE RAFAEL!!!");
    }
}
