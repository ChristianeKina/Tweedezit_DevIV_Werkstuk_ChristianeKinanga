package be.ehb.multec;

import java.util.ArrayList;

public class ShoppingCart implements Subject{

    private ArrayList<Product> products;
    private PaymentMethod payment;
    private Person person;
    private ArrayList<Observer> observers;
    private ShoppingCartState shopState;
    private ShoppingCartState assembleState;
    private ShoppingCartState finalState;
    private ShoppingCartState currentState;

    public ShoppingCart(Person person) {
        this.person = person;
        products = new ArrayList<>();
        observers = new ArrayList<>();
        shopState = new ShopState(this);
        assembleState = new AssembleState(this);
        finalState = new FinalState(this);
        setCurrentState(shopState);
    }


    public void addProductState(Product product){
        products.add(product);
    }

    public void removeProductState(Product product){
        products.remove(product);
    }

    public void payState(){
        this.payment.pay(this);
    }

    public void addProduct(Product product){
        this.currentState.addProduct(product);
    }

    public void removeProduct(Product product){
        this.currentState.removeProduct(product);
    }

    public void pay(){
        this.currentState.pay();
    }

    public void cancelShoppingCart(){
        this.currentState.cancel();
    }

    public void cancelShoppingCartState(){ updateObservers(this); }

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

    public ShoppingCartState getShopState() {
        return shopState;
    }

    public ShoppingCartState getAssembleState() {
        return assembleState;
    }

    public ShoppingCartState getFinalState() {
        return finalState;
    }

    public ShoppingCartState getCurrentState() {
        return currentState;
    }

    public PaymentMethod getPayment() { return payment; }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Person getPerson() {
        return person;
    }

    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }

    public void setCurrentState(ShoppingCartState currentState) {
        this.currentState = currentState;
    }

}
