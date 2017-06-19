/**
 * Created by Pavel on 21.12.2016.
 */
public class Order extends TypeDrink{

    int numOrder;
    Order(int numOrder, String nameDrinkInOrder, int quantityMlLitres){
        super(nameDrinkInOrder, quantityMlLitres);
        this.numOrder = numOrder;
    }

    public int getNumOrder() {
        return numOrder;
    }

    @Override
    public String toString() {
        return super.toString() + "numOrder " + numOrder;
    }

    @Override
    public int hashCode(){
        final int PRIME = 31;
        int result = 37;
        result = PRIME * result + super.getQuantityMlLitres();
        result = PRIME * result + getNumOrder();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj instanceof Waiter) { //если есть унаследованные классы
            Order order = (Order) obj;
            if (super.nameDrink != null && super.getNameDrink() != null) {
                return order.getNameDrink().equals(super.nameDrink) && order.getQuantityMlLitres() == super.quantityMlLitres &&
                order.numOrder == this.numOrder;
            }
        }
        return false;
    }
}
