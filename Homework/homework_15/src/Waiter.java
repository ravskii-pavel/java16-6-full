/**
 * Created by Pavel on 21.12.2016.
 */
public class Waiter {

    int age;
    double tipsInDay = 0;
    String name;
    Bar bar;

    public Waiter(String name, int age, Bar bar) {
        this.age = age;
        this.name = name;
        this.bar = bar;
    }

    public void takeTips(float allTips){
        if (allTips < 0){
            allTips = 0;
        }
        bar.allTips += allTips;
    }
    public void takeOrder(String nameDrink, int quantityMlLitres) {
       nameDrink = nameDrink.trim().toLowerCase();
       if (bar.isNameDrink(nameDrink)){
           if(bar.isPositiveNum(quantityMlLitres) == false){
               System.out.println("Введитеп положительное количество напитка");
           }
           else if(bar.isDrinkEnough(nameDrink, quantityMlLitres)) {
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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getTipsInDay() {
        return tipsInDay;
    }

    @Override
    public int hashCode(){
        final int PRIME = 31;
        int result = 37;
        result = PRIME * result + getAge();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj instanceof Waiter) { //если есть унаследованные классы
            Waiter waiter = (Waiter) obj;
            if (this.name != null && waiter.getName() != null) {
                return waiter.getName().equals(this.name) && waiter.age == this.age && waiter.tipsInDay == this.tipsInDay;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "age: " + age + "\ntipsInDay: " + tipsInDay + "\nName: " + name;
    }
}

