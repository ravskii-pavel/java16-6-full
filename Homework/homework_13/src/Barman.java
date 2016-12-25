/**
 * Created by Pavel on 21.12.2016.
 */
public class Barman extends Waiter {

    public Barman(String name, int age,  Bar bar) {
        super(name, age, bar);
    }

    public void compleateOrder(int numOrder){
        if(bar.orders[numOrder] != null){
            bar.typeDrinks[bar.whichDrinkAnalog(bar.orders[numOrder].nameDrink)].quantityMlLitres -= bar.orders[numOrder].quantityMlLitres;
            bar.orders[numOrder] = null;
        }
        else {
            System.out.println("Нет заказа с таким №: " + numOrder);
        }
    }

}
