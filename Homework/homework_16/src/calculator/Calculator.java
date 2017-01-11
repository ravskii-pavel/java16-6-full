package calculator;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by Ravskiy Pavel on 09.01.2017.
 */
public class Calculator {

    public static JTextField textField = new JTextField();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(500, 500);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        frame.add(panel1);
        frame.add(panel2);
        panel1.setSize(200, 170);
        panel1.setBackground(Color.blue);
        //panel1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        //panel1.setBorder(BorderFactory.createLineBorder(1,2,5,1,Color.red));
        panel1.setBorder(BorderFactory.createMatteBorder(1,2,5,1,Color.red));
        //BorderLayout borderLayout = new BorderLayout();
        //frame.setLayout(borderLayout);
        //frame.setResizable(false);

        //frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //BorderLayout borderLayout1 = new BorderLayout();
        //frame.setLayout(borderLayout);

        Button aButton = new Button("Enter");
        Button aButton1 = new Button("Enter1");
        MainPanel mainPanel= new MainPanel();

        panel1.add(mainPanel, "South");
        //frame.add(aButton, "South");
        panel2.add(aButton1, "West");
        //frame.add(textField, borderLayout.NORTH);


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




        frame.setVisible(true);
    }
}
