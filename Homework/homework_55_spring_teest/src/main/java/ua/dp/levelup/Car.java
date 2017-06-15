package ua.dp.levelup;

import java.lang.reflect.Field;

/**
 * Created by Ravskiy Pavel on 14.06.2017.
 */
public class Car {
    double maxSpeed;
    String model;
    Color color;

    public Car() {}
    public Car(Color color, String model, double maxSpeed) {
        this.maxSpeed = maxSpeed;
        this.model = model;
        this.color = color;
    }

    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }
    public void setModel(String model) { this.model = model; }
    public void setColor(Color color) { this.color = color; }

    public String toJson() throws IllegalAccessException {
        Class c = this.getClass();
        Field[] fieldsClass = c.getDeclaredFields();
        String result = this.getClass().getSimpleName() + ":\n" + "{\n\t";
        for(int i = 0; i < fieldsClass.length; i++){
            if(i == fieldsClass.length - 1){
                result = result +"\""+fieldsClass[i].getName()+"\": " + fieldsClass[i].get(this)+ "\n}";
            }
            else result = result +"\""+fieldsClass[i].getName()+"\": " + fieldsClass[i].get(this)+ ",\n\t";
        }
        return result;
    }

    public void printFields(){
        System.out.println(maxSpeed);
        System.out.println(model);
        System.out.println(color);
    }
}
