package by.mvas.sprgr.model;

/**
 * @author Max
 */
public class Person {

    private String name;
    private String lastName;
    private Address address;

    public Person() {
    }

    public Person(String name, String lastName, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person {" + "name=" + name + ", lastName=" + lastName + ", address= " + address.toString() + '}';
    }

}
