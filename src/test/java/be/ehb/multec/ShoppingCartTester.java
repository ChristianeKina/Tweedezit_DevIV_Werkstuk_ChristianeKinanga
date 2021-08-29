package be.ehb.multec;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ShoppingCartTester {

    private ShoppingCart shoppingCart;
    private Shop shop;

    @BeforeEach
    public void setUp() {
        Person person = new Person("Chris", "Malr", LocalDate.of(2003,03,16));
        shoppingCart = new ShoppingCart(person);
        shop = new Shop();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void shoppingCartStateTest(){
        assertEquals(shoppingCart.getCurrentState(), shoppingCart.getShopState());
        shop.addShoppingCart(shoppingCart);
        assertEquals(shoppingCart.getCurrentState(), shoppingCart.getAssembleState());
        shop.assembleShoppingCarts();
        assertEquals(shoppingCart.getCurrentState(), shoppingCart.getFinalState());
    }

    @Test
    public void shoppingCartWrongStateTest(){
        try {
            shoppingCart.setPayment(new PayWithCard());
            shoppingCart.pay();
        } catch (IllegalStateException e){
        }
    }

    @Test
    public void observerTest(){
       shop.addShoppingCart(shoppingCart);
       shoppingCart.cancelShoppingCart();
       assertTrue(shop.getShoppingCarts().isEmpty());
    }

    @Test
    public void strategyTest(){
            shop.addShoppingCart(shoppingCart);
            shop.assembleShoppingCarts();
            shoppingCart.setPayment(new PayWithCard());
            shoppingCart.pay();
            shoppingCart.setPayment(new PayWithCash());
            shoppingCart.pay();
    }

    @Test
    public void findSimilarItemsTest(){
        Person person = new Person("Chris", "Malr", LocalDate.of(2003,04,17));
        Person person1 = new Person("Lele", "Pmos", LocalDate.of(2004,05,16));
        Person person2 = new Person("Gandi", "Tres", LocalDate.of(2005,06,15));
        Product product = new Product("paper", 6);
        Product product1 = new Product("bag", 7);
        Product product2 = new Product("lamp", 3);
        ShoppingCart shoppingCart = new ShoppingCart(person);
        ShoppingCart shoppingCart1 = new ShoppingCart(person1);
        ShoppingCart shoppingCart2 = new ShoppingCart(person2);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);
        shoppingCart1.addProduct(product);
        shoppingCart1.addProduct(product1);
        shoppingCart2.addProduct(product2);
        shop.addShoppingCart(shoppingCart);
        shop.addShoppingCart(shoppingCart1);
        shop.addShoppingCart(shoppingCart2);
        shop.getSimilarShoppingCarts();

    }
}