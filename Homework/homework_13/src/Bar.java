/**
 * Created by Pavel on 20.12.2016.
 */
public class Bar {
    int initialSize;
    String barName;
    float quantityTips;
    TypeDrink [] typeDrinks;
    Order [] orders;

    Bar(){
        this.initialSize = 3;
        this.typeDrinks = new TypeDrink[initialSize];
    }
    Bar(int initialSize){
        this.initialSize = initialSize;
        this.typeDrinks = new TypeDrink[initialSize];
    }

    public int currentLoadArray(TypeDrink[] typeDrinks){
        int size = 0;
        while (typeDrinks[size] != null) {
            size++;
            if (size == typeDrinks.length) {
                return size;
            }
        }
        return size;
    }

    public int checkDrinkAnalog(String nameDrink){
        for(int i = 0; i < typeDrinks.length && typeDrinks[i] != null; i++){
            if (typeDrinks[i].nameDrink == nameDrink) {
                return i;
            }
        }
        return (-1);
    }

    public void addNewDrinkInBar(String nameDrink, int quantityMlLitres){
        int size = 0;
        Object [] obj = (Object[])typeDrinks;
        if (checkDrinkAnalog(nameDrink) < 0) {
            size = currentLoadArray(typeDrinks);
            obj = changeSizeArray(typeDrinks, size);
            typeDrinks = (TypeDrink[])obj;
            typeDrinks[size] = new TypeDrink(nameDrink, quantityMlLitres);
        }
        else{
            size = checkDrinkAnalog(nameDrink);
            typeDrinks[size].quantityMlLitres += quantityMlLitres;
        }
    }

    public Object[] changeSizeArray(Object []objects, int size){
        int initialSize = this.initialSize;
        float maxLoad = 0.65f;
        float minLoad = 0.6f;
        float currentLoad = size/(initialSize*1.0f);
        if(currentLoad >= maxLoad){
            this.initialSize = (int)(size * 1.5);
            if (objects == typeDrinks){
                Object[] tmp = new TypeDrink[this.initialSize];
            }
            else{
                Object[] tmp = new Order[this.initialSize];
            }
            Object[] tmp = new TypeDrink[this.initialSize];
            for (int i = 0; i < size; i++){
                tmp[i] = objects[i];
            }
            objects = tmp; //меняем ссылку на новый увеличенный массив
        }
        return objects;
    }

}
