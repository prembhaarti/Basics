package java8.interview;

public class ImmutableDemo {
}

/**
 * 1. Declare the class as final so it can’t be extended.
 * 2. Make all fields private so that direct access is not allowed.
 * 3. Don’t provide setter methods for variables
 * 4. Make all mutable fields final so that it’s value can be assigned only once.
 * 5. Initialize all the fields via a constructor performing deep copy.
 * 6. Perform cloning of objects in the getter methods to
 *    return a copy rather than returning the actual object reference
 */
final class Employee{ //class final

    private final int id;
    private final String name; //fields private and final
    private final Address address; //Any other class should be deep cloneable

    public Employee(int id, String name, Address address) {//setting using constructors only
        this.id = id;
        this.name = name;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //returning only clone of objects, so it's content can't be changed
    public Address getAddress() throws CloneNotSupportedException {
        return address.clone();
    }
}

class Address implements Cloneable{
    private String address;
    private String city;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String address, String city) {
        this.address = address;
        this.city = city;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}