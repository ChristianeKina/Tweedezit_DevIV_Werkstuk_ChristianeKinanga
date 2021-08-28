package be.ehb.multec;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Observer{

    private String firstName;
    private String lastName;
    private LocalDate birthdate;

    public Person(String firstName, String lastName, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    @Override
    public void update(Object object) {
        ShoppingCart shoppingCart = (ShoppingCart) object;
        if (shoppingCart.getPerson().equals(this)){
            System.out.println("My shopping cart is ready to be picked up");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(birthdate, person.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthdate);
    }
}
