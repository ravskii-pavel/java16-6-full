package ua.dp.levelup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by java on 13.06.2017.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Greeting greetingBean = context.getBean("greetingBean", Greeting.class);
        /*Greeting greetingBeanPrototype = context.getBean("greetingBeanPrototype", Greeting.class);
        Greeting greetingBeanPrototype1 = context.getBean("greetingBeanPrototype", Greeting.class);
        Greeting greetingBeanSession = context.getBean("greetingBeanSession", Greeting.class);
*/
        Message bean1 = (Message) context.getBean("singleton-message");
        Message bean2 = (Message) context.getBean("singleton-message");

        Message bean3 = (Message) context.getBean("prototype-message");
        Message bean4 = (Message) context.getBean("prototype-message");

        System.out.println(bean1 + ": ");
        bean1.print();
        System.out.println(bean2 + ": ");
        bean2.print();
        System.out.println(bean3 + ": ");
        bean3.print();
        System.out.println(bean4 + ": ");
        bean4.print();
        /*Color colorWhiteBean = context.getBean("colorWhiteBean", Color.class);
        Color colorRedBean = context.getBean("colorRedBean", Color.class);*/

       /* Car carBean = context.getBean("carBean", Car.class);
        Car carConstructorBean = context.getBean("carConstructorBean", Car.class);*/
        /*greetingBean.sayHello();*/
        /*carBean.printFields();*/
/*        carConstructorBean.printFields();
        System.out.println(colorWhiteBean);
        System.out.println(colorRedBean);*/
        /*PC pcBean = context.getBean(PC.class);
        System.out.println(pcBean);*/
/*        System.out.println(carBean.toJson());
        System.out.println(carConstructorBean.toJson());*/

        //context.close();
       /* UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.doMagic();*/
        ((ConfigurableApplicationContext)context).close();
    }
}