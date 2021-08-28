package be.ehb.multec;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

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
        Assertions.assertThrows(IllegalStateException.class, () -> {
            shoppingCart.setPayment(new PayWithCard());
            shoppingCart.pay();
        });
    }

    @Test
    public void observerTest(){
       shop.addShoppingCart(shoppingCart);
       shoppingCart.cancelShoppingCart();
       assertTrue(shop.getShoppingCarts().isEmpty());
    }

    @Test
    public void strategyTest(){
        Assertions.assertDoesNotThrow( () -> {
            shop.addShoppingCart(shoppingCart);
            shop.assembleShoppingCarts();
            shoppingCart.setPayment(new PayWithCard());
            shoppingCart.pay();
            shoppingCart.setPayment(new PayWithCash());
            shoppingCart.pay();
        });
    }

    @Test
    public void Test(){
        Product product = new Product("mllk", 6);
        Product product1 = new Product("mze", 7);
        Product product2 = new Product("mzsef", 3);
        ShoppingCart shoppingCart = new ShoppingCart(null);
        ShoppingCart shoppingCart1 = new ShoppingCart(null);
        ShoppingCart shoppingCart2 = new ShoppingCart(null);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);
        shoppingCart1.addProduct(product);
        shoppingCart1.addProduct(product1);
        shoppingCart2.addProduct(product2);
        shop.addShoppingCart(shoppingCart);
        shop.addShoppingCart(shoppingCart1);
        shop.addShoppingCart(shoppingCart2);
        ArrayList<ShoppingCart> findSimilarItems = shop.getSimilarShoppingCarts();
        System.out.println("fytuuyu");
    }
}