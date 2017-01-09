/**
 * Created by java on 23.12.2016.
 */
public class Coin {

    int weight;
    int diameter;

    public Coin(int diameter, int weight) throws CoinLogicExeption{
      if(diameter < 0) throw new CoinLogicExeption("Diametr should be positive");
       this.diameter = diameter;
       this.weight = weight;
        //System.out.println("Отрицательное значение");
       }


    public int getDiameter() {
        return diameter;
    }
    public int getWeight() {

        return weight;
    }
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
    public void setWeight(int weight) {

        this.weight = weight;
    }
}
