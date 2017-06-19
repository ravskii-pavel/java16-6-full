package ua.dp.levelup.model;

/**
 * Created by java on 11.11.2016.
 */
public class Square extends Shape {
    double side;


    double getPerimeter() {
        return side * 4;


    }

    Square() {

    }

    Square(double side) {
        this("Black", side);

    }

    Square(String color, double side) {
        this.color = color;
        this.side = side;

    }
}
