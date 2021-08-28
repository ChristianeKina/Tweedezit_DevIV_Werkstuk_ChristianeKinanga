package be.ehb.multec;

public class FinalState extends ShoppingCartState{


    public FinalState(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public void addProduct(Product product) {
        throw new IllegalStateException("YOU CANNOT ADD A PRODUCT WHILE YOU'RE IN THE FINAL STATE RAFAEL!!!");
    }

    @Override
    public void removeProduct(Product product) {
        throw new IllegalStateException("YOU CANNOT REMOVE A PRODUCT WHILE YOU'RE IN THE FINAL STATE RAFAEL!!!");
    }
}
