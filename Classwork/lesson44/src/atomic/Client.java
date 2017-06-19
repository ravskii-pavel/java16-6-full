package atomic;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by java on 18.04.2017.
 */
public class Client {

    private final int id;
    private AtomicInteger balance = new AtomicInteger(100);

    public Client(int id) {
        this.id = id;
    }

    public void increaseBalance(int inc) {
        System.out.println(new Date() + " " + "Client " + id + " totalBalance=" + balance.addAndGet(inc) + " , balanceChange= +" + inc);
    }

    public void reduceBalance(int red) {
        System.out.println(new Date() + " " + "Client " + id + " totalBalance=" + balance.updateAndGet(operand -> operand - red) + " , balanceChange= -" + red);
    }

    public int getBalance() {
        return this.balance.get();
    }

}
