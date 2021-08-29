package be.ehb.multec;

public class PayWithCash implements PaymentMethod{

    @Override
    public void pay(ShoppingCart cart) {
        System.out.println("Shopping cart paid with cash");
    }

}
