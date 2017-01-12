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

        /*JFrame frame = new JFrame("Calculator");
        frame.setSize(250, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);

        borderLayout.addLayoutComponent(textField, BorderLayout.NORTH);
        frame.add(textField);

        MainPanel mainPanel = new MainPanel();

        borderLayout.addLayoutComponent(mainPanel, BorderLayout.CENTER);
        frame.add(mainPanel);


       // frame.setLayout(borderLayout);
        frame.setVisible(true);*/




        JFrame frame = new JFrame("Calculator");
        frame.setSize(500, 500);
        textField.setSize(200,60);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.setResizable(false);
        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);

        //JPanel panel1 = new JPanel();
        //JPanel panel2 = new JPanel();
        MainPanel mainPanel= new MainPanel();
        //panel2.setBackground(Color.blue);
        mainPanel.setBorder(BorderFactory.createMatteBorder(1,2,5,1,Color.red));
        /*panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());*/
        //frame.add(panel1, borderLayout.NORTH);
        //frame.add(panel2, borderLayout.CENTER);

        //panel1.setBorder(BorderFactory.createMatteBorder(1,2,5,1,Color.red));
        //panel2.setBorder(BorderFactory.createMatteBorder(3,2,5,1,Color.blue));

        frame.add(textField, borderLayout.NORTH);
        frame.add(mainPanel, borderLayout.CENTER);

        frame.setVisible(true);
    }
}
