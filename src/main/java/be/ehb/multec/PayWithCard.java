package be.ehb.multec;

public class PayWithCard implements PaymentMethod{

    @Override
    public void pay(ShoppingCart cart) {
        System.out.println("Shopping cart paid with card");
    }
}
