import calculator.ArithmeticalOperations;
import calculator.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {
    static int counter = 0;

    public static void main(String[] args) {

        //System.out.println(-1.7);

        JFrame frame = new JFrame("This is my title");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); //разместить по центру экрана
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        MainPanel mainPanel = new MainPanel();


        //LabelPanel labelPanel = new LabelPanel();
        Menu menu = new Menu();

        layout.addLayoutComponent(menu, BorderLayout.PAGE_START);
        //layout.addLayoutComponent(labelPanel, BorderLayout.CENTER);

        frame.add(menu);
        //frame.add(labelPanel);

        JLabel label = new JLabel();
        label.setText("0");

        layout.addLayoutComponent(label, BorderLayout.LINE_START);
        frame.add(label);


        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText((++counter) + "");
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(30, 15));

        btnPanel.add(button);

        layout.addLayoutComponent(btnPanel, BorderLayout.CENTER);

        frame.add(btnPanel);

        frame.setLayout(layout);

        frame.setVisible(true);
//        Thread.sleep(2000);
//
//        frame.setState(Frame.ICONIFIED);
//
//        Thread.sleep(2000);
//
//        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
//
//        Thread.sleep(2000);
//
//        frame.setExtendedState(Frame.NORMAL);

    calculator();
}
    //-------------------------------------------------------------------------------------------------
    public static void calculator() {
        boolean isExit = false;
        String result = null;
        Scanner scanner = new Scanner(System.in);

        while (!isExit) {
            System.out.print("Enter operator:  ");
            String operator = scanner.next();

            System.out.print("Enter first operand:  ");
            Object firstOperand = ArithmeticalOperations.setType(scanner.next());
            //Object firstOperand = calculator.ArithmeticalOperations.setType((result != null) ? result : scanner.next());
            /*if (null != result) {
                System.out.println(result);
            }*/
            System.out.print("Enter second operand:  ");
            Object secondOperand = ArithmeticalOperations.setType(scanner.next());

            if ((firstOperand instanceof Double) || (secondOperand instanceof Double)) {
                firstOperand = ArithmeticalOperations.setType(firstOperand);
                secondOperand = ArithmeticalOperations.setType(secondOperand);
            } else {
                firstOperand = ArithmeticalOperations.setTypeInt(firstOperand);
                secondOperand = ArithmeticalOperations.setTypeInt(secondOperand);
            }

            result = ArithmeticalOperations.getResult(operator, firstOperand, secondOperand);
            System.out.println("Would you like to continue? Enter y/n: ");
            String exitWord = scanner.next();

            if (exitWord != null && exitWord.length() > 0 && !exitWord.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}
