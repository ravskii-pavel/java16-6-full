package ua.dp.levelup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by java on 13.06.2017.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Greeting greetingBean = context.getBean(Greeting.class);
        Car carBean = context.getBean("carBean", Car.class);
        Car carConstructorBean = context.getBean("carConstructorBean", Car.class);
        Color colorWhiteBean = context.getBean("colorWhiteBean", Color.class);
        Color colorRedBean = context.getBean("colorRedBean", Color.class);
        greetingBean.sayHello();
        carBean.printFields();
        carConstructorBean.printFields();
        System.out.println(colorWhiteBean);
        System.out.println(colorRedBean);

        System.out.println(carBean.toJson());
        System.out.println(carConstructorBean.toJson());
    }
}