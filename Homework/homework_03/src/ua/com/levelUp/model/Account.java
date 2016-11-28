package ua.com.levelUp.model;

/**
 * Created by Pavel on 15.11.2016.
 */
public class Account {

    int id;
    int amount;

    Account () {
        this(123, -98);
    }
    Account (int id){
        this.id = id;
    }
    Account (int id, int amount){
        this.id = id;
        this.amount = amount;
    }

    int getAmount(int amount){
        return amount;
    }

    int  getId(int id){
        return id;
    }
}
