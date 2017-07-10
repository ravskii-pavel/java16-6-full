package ua.dp.levelup;

/**
 * Created by java on 16.06.2017.
 */
public class User {

    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private double balance = 0;

    public User() {
    }

    public User(long id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public double increaseBalance(double inc) {
        return balance += inc;
    }

    public double decreaseBalance(double dec) throws Exception {
        if (balance - dec < 0) throw new Exception("Balance couldn't be negative");
        return balance -= dec;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
