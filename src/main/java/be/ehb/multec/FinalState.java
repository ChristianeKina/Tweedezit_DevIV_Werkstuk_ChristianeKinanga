package be.ehb.multec;

public class FinalState extends ShoppingCartState{


    public FinalState(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public void addProduct(Product product) {
        throw new IllegalStateException("You can't add a product when you're in the final state");
    }

    @Override
    public void removeProduct(Product product) {
        throw new IllegalStateException("You can't remove a product when you're in the final state");
    }
}
