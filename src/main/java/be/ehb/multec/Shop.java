package be.ehb.multec;

import java.util.ArrayList;

public class Shop implements Subject, Observer{

    private ArrayList<ShoppingCart> shoppingCarts;
    private ArrayList<Observer> observers;

    public Shop() {
        shoppingCarts = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addShoppingCart(ShoppingCart shoppingCart ) {
        shoppingCarts.add(shoppingCart);
        shoppingCart.setCurrentState(shoppingCart.getAssembleState());
        shoppingCart.addObserver(this);
    }

    public void assembleShoppingCart(ShoppingCart shoppingCart){
        if (shoppingCart != null){
            shoppingCart.setCurrentState(shoppingCart.getFinalState());
            shoppingCarts.remove(shoppingCart);
        }
    }

    public void assembleShoppingCarts(){
        ArrayList<ShoppingCart> getShoppingCart = getSimilarShoppingCarts();
        for (ShoppingCart shoppingCart: getShoppingCart) {
            assembleShoppingCart(shoppingCart);
        }
    }

    public ArrayList<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public ArrayList<ShoppingCart> getSimilarShoppingCarts(){
        int maxCommonItems = 0;
        ArrayList<ShoppingCart> similarShoppingCarts = new ArrayList<>();
        similarShoppingCarts.add(shoppingCarts.get(0));
        for (int i = 0; i < shoppingCarts.size(); i++) {
            for (int j = 0; j < shoppingCarts.size(); j++) {
                if (i != j){
                    int commonItems = countCommonItemsBetween(shoppingCarts.get(i), shoppingCarts.get(j));
                    if (commonItems > maxCommonItems){
                        maxCommonItems = commonItems;
                        similarShoppingCarts.clear();
                        similarShoppingCarts.add(shoppingCarts.get(i));
                        similarShoppingCarts.add(shoppingCarts.get(j));
                        System.out.println(shoppingCarts.get(i).getPerson() + " and " + shoppingCarts.get(j).getPerson() + " have " + commonItems + " similar items namely" + shoppingCarts.get(j).getProducts());
                    }
                }
            }
        }
        return similarShoppingCarts;
    }

    private int countCommonItemsBetween(ShoppingCart shoppingCart, ShoppingCart shoppingCart1) {
        int commonItems = 0;
        for (int i = 0; i < shoppingCart.getProducts().size(); i++) {
            for (int j = 0; j < shoppingCart1.getProducts().size(); j++) {
                if (shoppingCart.getProducts().get(i).equals(shoppingCart1.getProducts().get(j))){
                    commonItems += 1;
                }
            }
        }
        return commonItems;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void updateObservers(Object object) {
        for (Observer o: observers) {
            o.update(object);
        }
    }

    @Override
    public void update(Object object) {
        ShoppingCart shoppingCart = (ShoppingCart) object;
        shoppingCarts.remove(shoppingCart);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shoppingCarts=" + shoppingCarts +
                '}';
    }
}
