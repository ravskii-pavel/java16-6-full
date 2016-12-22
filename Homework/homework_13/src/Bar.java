/**
 * Created by Pavel on 20.12.2016.
 */
public class Bar {
    int initialSize;
    String barName;
    float quantityTips;
    TypeDrink[] typeDrinks;
    Order [] orders;

    Bar(){
        this.initialSize = 3;
        this.typeDrinks = new TypeDrink[initialSize];
    }
    Bar(int initialSize){
        this.initialSize = initialSize;
        this.typeDrinks = new TypeDrink[initialSize];
    }

    public void addNewDrinkInBar(String nameDrink, int quantityMlLitres){
        float currentLoad = size/(initialSize*1.0f);
        if(currentLoad >= maxLoad){
            initialSize = (int)(size * 1.5);
            int[] tmp = new int[initialSize];
            for (int i = 0; i < size; i++){
                tmp[i] = array[i];
            }
            array = tmp; //меняем ссылку на новый увеличенный массив
        }
        array[size++] = n;

    }

}
