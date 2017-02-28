/**
 * Created by Pavel on 20.12.2016.
 */
public class Bar {
    int initialSize;
    float allTips;
    String barName;
    TypeDrink [] typeDrinks;
    Order [] orders;
    Waiter [] waiters;
    Barman [] barmen;


    Bar(String barName){
        this.initialSize = 3;
        this.allTips = 0;
        this.barName = barName;
        this.typeDrinks = new TypeDrink[initialSize];
		this.orders = new Order[initialSize];
        this.waiters = new  Waiter[initialSize];
        this.barmen = new  Barman[initialSize];
    }

    // Разделить чаевые поровну, между официантами
    public double shareAllTips(){
        double tipsInDay = 0;
        int quantityWaiters = quantityEmployeesInBar(waiters);
        int quantityBarmen = quantityEmployeesInBar(barmen);
        int quantityAllEmployees = quantityWaiters + quantityBarmen;
        if (barmen == null || waiters == null){
            return 0;
        }
        else {
            for (int i = 0; i < waiters.length; i++) {
                if (waiters[i] != null) {
                    tipsInDay = waiters[i].tipsInDay = this.allTips / quantityAllEmployees;
                }
            }
            for (int i = 0; i < barmen.length;  i++) {
                if(barmen[i] != null){
                    barmen[i].tipsInDay = this.allTips / quantityAllEmployees;
                }
            }
            this.allTips = 0;
            return tipsInDay;
        }
    }
    //Количество работников в Баре
    public int quantityEmployeesInBar(Object[] objects){
        int quantityEmployees = 0;
            for (int i = 0; objects != null && i < objects.length; i++) {
                if (objects[i] != null) {
                    quantityEmployees++;
                }
            }
        return quantityEmployees;
    }
    // поиск элемента массиаа совпадающего напитка
    public int whichDrinkAnalog(String nameDrink){
        int i = 0;
        for(i = 0; nameDrink != null && typeDrinks[i] != null && i < typeDrinks.length; i++){
            if (typeDrinks[i].nameDrink.equals(nameDrink)) {
                break;
            }
        }
        return i;
    }
    // Проверяет существует ли такой напиток в баре
    public boolean isNameDrink(String nameDrink){
        for (int i = 0; nameDrink != null && i < typeDrinks.length && typeDrinks[i] != null; i++) {
            if (typeDrinks[i].nameDrink.equals(nameDrink)) {
                return true;
            }
        }
        return false;
    }
    // Проверяет существует ли такой заказ в баре
    public boolean isOrderExist(int numOrder){
        if (numOrder >= 0 && numOrder < orders.length && orders[numOrder] != null) {
           return true;
        }
        return false;
    }
    public boolean isPositiveNum(int num){
        if (num > 0) {
            return true;
        }
        return false;
    }

    //количество заказываемого напитка в необработанных заказах
    public int quantityDrinkInNotCompleateOrders(String nameDrink){
        int quantityDrinkInOrders = 0;
        for (int i = 0; i < orders.length && orders[i] != null;  i++) {
            if (orders[i].nameDrink.equals(nameDrink)) {
                quantityDrinkInOrders += orders[i].quantityMlLitres;
            }
        }
        return quantityDrinkInOrders;
    }
    // Достаточно ли количества заказываемого напитка в баре и не превышает ли количество этого напитка в необработанных заказах
    public boolean isDrinkEnough(String nameDrink, int quantityMlLitres){
        if(quantityMlLitres > 0 && typeDrinks[whichDrinkAnalog(nameDrink)].quantityMlLitres >= quantityMlLitres + quantityDrinkInNotCompleateOrders(nameDrink)){
            return true;
        }
        else {
            return false;
        }
    }

    // Добавление нового напиитка в бар, если такой напиток сущесвует - пополняется только его объем
    public void addDrinkInBar(String nameDrink, int quantityMlLitres){
        int numDrink = 0;
        nameDrink = nameDrink.trim().toLowerCase();
        Object [] obj = (Object[])typeDrinks;
        if(isPositiveNum(quantityMlLitres) == false){
            System.out.println("Введитеп положительное количество напитка");
        }
        else if (isNameDrink(nameDrink) == false) {
            numDrink = currentLoadArray(typeDrinks);
            obj = changeSizeArray(typeDrinks, numDrink);
            typeDrinks = (TypeDrink[])obj;
            typeDrinks[numDrink] = new TypeDrink(nameDrink, quantityMlLitres);
        }
        else{
            numDrink = whichDrinkAnalog(nameDrink);
            typeDrinks[numDrink].quantityMlLitres += quantityMlLitres;
        }
    }

    public String addEmployee (String employeeName, int age, String position, Bar bar){
        if (position == null) {
            position = "null";
        }
        position = position.toLowerCase().trim();
        if(position == "waiter"){
            int numWaiters = currentLoadArray(waiters);
            Object [] obj = (Object[]) waiters;
            obj = changeSizeArray(waiters, numWaiters);
            waiters = (Waiter[])obj;
            waiters[numWaiters] = new Waiter(employeeName, age, bar);

            return position;
        }
        else if(position == "barman"){
            int numBarman = currentLoadArray(barmen);
            Object [] obj = (Object[])barmen;
            obj = changeSizeArray(barmen, numBarman);
            barmen = (Barman [])obj;
            barmen[numBarman] = new Barman(employeeName, age, bar);
            return position;
        }
        else {
            return "Нет такой должности - " + position;
        }
    }
    public int isEmployee(String employeeName, int age, String position){
        if(position == "waiter"){
            for (int i =0; i < waiters.length; i++) {
                if (employeeName == waiters[i].name && age == waiters[i].age) {
                    return i;
                }
            }
        }
        else if(position == "barman"){
            for (int i =0; i < barmen.length; i++){
                if(employeeName == barmen[i].name && age == barmen[i].age){
                   return i;
                }
            }
        }
        return -1;
    }
    public void delEmployee (String employeeName, int age, String position){
        if (position == null) {
            position = "null";
        }
        if (employeeName == null){
            employeeName = "null";
        }
        position = position.toLowerCase().trim();
        if(isEmployee(employeeName, age, position) >= 0){
            if (position == "waiter") {
                waiters[isEmployee(employeeName, age, position)] = null;
            } else if (position == "barman") {
                barmen[isEmployee(employeeName, age, position)] = null;
            } else {
                System.out.println("Нет такой должности - " + position);
            }
        }
        else {
            System.out.println("Нет такого сотрудника в баре!");
        }
    }

    // Текущая загрузка массива объектов
    public int currentLoadArray(Object[] objects){
        int size = 0;
        while (objects[size] != null) {
            size++;
            if (size == objects.length) {
                return size;
            }
        }
        return size;
    }

    // Увеличение длины массива объектов
    public Object[] changeSizeArray(Object []objects, int size){
        int initialSize = this.initialSize;
        float maxLoad = 0.65f;
        float currentLoad = size/(initialSize*1.0f);
        if(currentLoad >= maxLoad){
            initialSize = (int)(size * 1.5);
            if (objects == typeDrinks){      //нежелательно использовать insanceof - т.к. есть классы наследники
                Object[] tmp = new TypeDrink[initialSize];
                for (int i = 0; i < size; i++){
                    tmp[i] = objects[i];
                }
                objects = tmp; //меняем ссылку на новый увеличенный массив
            }
            else if(objects == orders){    //нежелательно использовать insanceof - т.к. есть классы наследники
                Object[] tmp = new Order[initialSize];
                for (int i = 0; i < size; i++){
                    tmp[i] = objects[i];
                }
                objects = tmp; //меняем ссылку на новый увеличенный массив
            }
            else if (objects == waiters){   //нежелательно использовать insanceof - т.к. есть классы наследники
                Object[] tmp = new Waiter[initialSize];
                for (int i = 0; i < size; i++){
                    tmp[i] = objects[i];
                }
                objects = tmp; //меняем ссылку на новый увеличенный массив
            }
            else {
                Object[] tmp = new Barman[initialSize];
                for (int i = 0; i < size; i++){
                    tmp[i] = objects[i];
                }
                objects = tmp; //меняем ссылку на новый увеличенный массив
            }
        }
        return objects;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public String getBarName() {
        return barName;
    }

    public float getAllTips() {
        return allTips;
    }

    @Override
    public int hashCode(){
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + getInitialSize();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj instanceof Bar) {
            Bar bar = (Bar) obj;
            if (this.barName != null && bar.getBarName() != null) {
                return bar.getBarName().equals(this.barName) && bar.initialSize == this.initialSize && bar.allTips == this.allTips;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "initialSize: " + initialSize + "\nallTips: " + allTips + "\nbarName: " + barName;
    }
}
