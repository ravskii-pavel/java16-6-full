/**
 * Created by Pavel on 21.12.2016.
 */
public class Waiter {

    int age;
    float tipsInDay;
    String name;
    Bar bar;

    public Waiter(String name, int age, Bar bar) {
        this.age = age;
        this.name = name;
        this.bar = bar;
    }

    public void takeTips(float allTips){
        bar.allTips += allTips;
    }
    public void takeOrder(String nameDrink, int quantityMlLitres) {
       nameDrink = nameDrink.trim().toLowerCase();
       if (bar.isNameDrink(nameDrink)){
           if(bar.isDrinkEnough(nameDrink, quantityMlLitres)) {
               int size = bar.currentLoadArray(bar.orders);
               Object[] obj = (Object[])bar.orders;
               obj = bar.changeSizeArray(bar.orders, size);
               bar.orders = (Order[]) obj;
               bar.orders[size] = new Order(size, nameDrink, quantityMlLitres);
               //Bar.orders[Bar.checkDrinkAnalog(nameDrink)].quantityMlLitres -= quantityMlLitres;
           }
           else{
               System.out.println("К сожалению, нет такого количества " + bar.typeDrinks[bar.whichDrinkAnalog(nameDrink)].nameDrink + ", у нас осталось - " +
               (bar.typeDrinks[bar.whichDrinkAnalog(nameDrink)].quantityMlLitres - (bar.quantityDrinkInNotCompleateOrders(nameDrink))));
           }
       }
       else {
           System.out.println("В баре " + bar.barName + " нет такого напитка");
       }
   }
}

