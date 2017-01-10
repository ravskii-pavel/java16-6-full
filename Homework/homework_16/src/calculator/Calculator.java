package calculator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ravskiy Pavel on 09.01.2017.
 */
public class Calculator {

    public static JTextField textField = new JTextField();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(500, 500);
        //frame.setResizable(false);

        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout borderLayout = new BorderLayout();
        BorderLayout borderLayout1 = new BorderLayout();

        //frame.add(borderLayout.NORTH);
        Button aButton = new Button("Enter");
        Button aButton1 = new Button("Enter1");

        frame.add(aButton, "South");
        frame.add(textField, borderLayout.NORTH);

        frame.setLayout(borderLayout1);
        //BorderLayout borderLayout = new BorderLayout();
        //Button aButton = new Button();
        //borderLayout.addLayoutComponent(, BorderLayout.NORTH);
        //borderLayout.addLayoutComponent(frame.add(textField), BorderLayout.SOUTH);

        //borderLayout.addLayoutComponent(textField, BorderLayout.WEST);
        //borderLayout.addLayoutComponent(textField, BorderLayout.EAST);
        //borderLayout.addLayoutComponent(textField, BorderLayout.CENTER);

        //borderLayout.addLayoutComponent(textField, BorderLayout.NORTH);
        //frame.add(textField);
        //borderLayout1.addLayoutComponent(textField, BorderLayout.SOUTH);

        //.add(textField);

        MainPanel mainPanel= new MainPanel();


        frame.setVisible(true);
    }
}
