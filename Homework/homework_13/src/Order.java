/**
 * Created by Pavel on 21.12.2016.
 */
public class Order extends TypeDrink{

    int numOrder;
    Order(int numOrder, String nameDrinkInOrder, int quantityMlLitres){
        super(nameDrinkInOrder, quantityMlLitres);
        this.numOrder = numOrder;
    }
}
