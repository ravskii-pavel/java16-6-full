/**
 * Created by Pavel on 21.12.2016.
 */
public class Barman extends Waiter {

    public Barman(String name, int age,  Bar bar) throws NotExistBarException {
        super(name, age, bar);
    }

    public String compleateOrder(int numOrder){
        if(bar.isOrderExist(numOrder)){
            bar.typeDrinks[bar.whichDrinkAnalog(bar.orders[numOrder].nameDrink)].quantityMlLitres -= bar.orders[numOrder].quantityMlLitres;
            bar.orders[numOrder] = null;
            return "Заказ " + numOrder + " - выполнен";
        }
        return "Нет заказа с таким №: " + numOrder;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
