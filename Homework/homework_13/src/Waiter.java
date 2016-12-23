/**
 * Created by Pavel on 21.12.2016.
 */
public class Waiter {

    String name;
    int age;

   public void takeTips(float allTipss){
        Bar.allTips += allTipss;
   }
   public void takeOrder(String nameDrink, int quantityMlLitres) {
       nameDrink = nameDrink.trim().toLowerCase();
       int i = 0;
       int size = 0;

       Object[] obj = (Object[])Bar.orders;
       size = Bar.currentLoadArray(Bar.orders);
       obj = Bar.changeSizeArray(Bar.orders, size);
       Bar.orders = (Order[]) obj;
       if(Bar.isDrinkEnough(nameDrink, quantityMlLitres)) {
           Bar.orders[size] = new Order(nameDrink, quantityMlLitres);
           //Bar.orders[Bar.checkDrinkAnalog(nameDrink)].quantityMlLitres -= quantityMlLitres;
       }
       else{
           System.out.println("К сожалению, нет такого количества " + Bar.typeDrinks[Bar.checkDrinkAnalog(nameDrink)].nameDrink + ", у нас осталось - " +
           Bar.typeDrinks[Bar.checkDrinkAnalog(nameDrink)].quantityMlLitres);
       }
   }
    public void isDrinkEnough(String nameDrinkInOrder, int quantityMlLitresInOrder){
        Bar.howMuchQuantity(nameDrinkInOrder, quantityMlLitresInOrder);

    }
}

