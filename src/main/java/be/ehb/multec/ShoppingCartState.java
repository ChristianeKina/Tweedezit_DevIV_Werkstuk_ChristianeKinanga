package be.ehb.multec;

public abstract class ShoppingCartState{

    private ShoppingCart shoppingCart;

    public ShoppingCartState(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addProduct(Product product){
        shoppingCart.addProductState(product);
    }

    public void removeProduct(Product product){ shoppingCart.removeProductState(product); }

    public void pay(){
        shoppingCart.payState();
    }

    public void cancel(){ shoppingCart.cancelShoppingCartState(); }

}

