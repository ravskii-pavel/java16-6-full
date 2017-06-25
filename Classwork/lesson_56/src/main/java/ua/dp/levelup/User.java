package ua.dp.levelup;

/**
 * Created by java on 16.06.2017.
 */
public class User {

    private long id;
    private String email;
    public String name;
    public String lastName;
    private double balance;

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }
/*    public User(String name) {
        this.name = name;
    }*/

    public String getName() {   return name;  }
    public String getLastName() {  return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public double getBalance() { return balance; }
    public double increaseBalance(double inc){ return balance += inc;}

    public double decreaseBalance(double dec) throws Exception {
        if (balance < 0) throw new Exception("Balance < 0");
        return balance -= dec;
    }

    public long getId() {  return id;}
    public void setId(long id) { this.id = id;}
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}

    public User(long id, String email, String name, String lastName) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
