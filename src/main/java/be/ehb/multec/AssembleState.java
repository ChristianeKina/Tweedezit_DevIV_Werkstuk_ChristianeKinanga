package be.ehb.multec;

public class AssembleState extends ShoppingCartState{


    public AssembleState(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public void addProduct(Product product) {
    throw new IllegalStateException("YOU CANNOT ADD A PRODUCT WHILE YOU'RE IN THE SHOP STATE RAFAEL!!!");
    }
}
