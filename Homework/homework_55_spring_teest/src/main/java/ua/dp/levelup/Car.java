package ua.dp.levelup;
import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Ravskiy Pavel on 14.06.2017.
 */
@Entity
@Table(name = "cars", indexes = {
        @Index(columnList = "id", name = "car_idx")
})
@Getter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "maxSpeed", nullable = false, unique = false)
    private double maxSpeed;

    @Column(name = "model", nullable = false, unique = false)
    private String model;

    @Column(table = "cars", name = "color", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Color color;

    public Car() {}
    public Car(Color color, String model, double maxSpeed) {
        this.maxSpeed = maxSpeed;
        this.model = model;
        this.color = color;
    }
           /* Class clazz = Class.forName(c.getName());
        c.getConstructor().newInstance();
        System.out.println(c.getConstructor().newInstance());
        System.out.println(clazz.getConstructor().newInstance());
        System.out.println(c.getName());
        System.out.println(clazz);*/
        /*String result = this.getClass().getSimpleName() + ":\n" + "{\n\t";*/
        /*System.out.println(fieldsClass[0].getType());*/

    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }
    public void setModel(String model) { this.model = model; }
    public void setColor(Color color) { this.color = color; }

    public String toJson() throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class c = this.getClass();
        Field[] fieldsClass = c.getDeclaredFields();
        String result = "{\n\t";
        for(int i = 0; i < fieldsClass.length; i++){
            if(i == fieldsClass.length - 1){
                result = result +"\""+fieldsClass[i].getName()+"\": " + "\""+ fieldsClass[i].get(this) + "\""+ "\n}";
            }
            else result = result +"\""+fieldsClass[i].getName()+"\": " + "\""+ fieldsClass[i].get(this) + "\"" + ",\n\t";
        }
        return result;
    }
    public void printFields(){
        System.out.println(maxSpeed);
        System.out.println(model);
        System.out.println(color);
    }
}
