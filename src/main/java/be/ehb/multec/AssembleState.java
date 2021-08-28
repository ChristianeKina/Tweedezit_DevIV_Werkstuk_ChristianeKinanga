package be.ehb.multec;

public class AssembleState extends ShoppingCartState{


    public AssembleState(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public void addProduct(Product product) {
    throw new IllegalStateException("You can't add a product while you're in the assemble state");
    }
}
