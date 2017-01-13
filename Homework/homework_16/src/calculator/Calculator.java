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
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);
        //borderLayout.addLayoutComponent(textField, BorderLayout.NORTH);
        textField.setText("0");
        frame.add(textField, borderLayout.NORTH);

        MainPanel mainPanel = new MainPanel();
        //borderLayout.addLayoutComponent(mainPanel, BorderLayout.CENTER);
        frame.add(mainPanel, borderLayout.CENTER);
        frame.setVisible(true);

    }
}
