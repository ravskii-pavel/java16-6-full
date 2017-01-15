package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by java on 27.12.2016.
 */
public class OperationPanel extends JPanel {

    public OperationPanel() {
        GridLayout gridLayout = new GridLayout(3, 2, 5, 5);

        String[] opS = {"/", "*", "+", "-", "=", "C"};

        JButton button;
        for (String s : opS) {
            button = new JButton(s);
            button.addActionListener(getCLickListener());
            gridLayout.addLayoutComponent(s, button);
            add(button);
        }
        setLayout(gridLayout);
    }
    public boolean ifExistOperation(String textFieldLine){
        if (textFieldLine.endsWith("-") || textFieldLine.endsWith("+") || textFieldLine.endsWith("/") || textFieldLine.endsWith("*")){
            return true;
        }
        return false;
    }
    public boolean ifSecondOperation(String textFieldLine){
        if (textFieldLine.startsWith("-")){
            textFieldLine = (textFieldLine.substring(1, textFieldLine.length()));
        }
        if (textFieldLine.contains("-") || textFieldLine.contains("+") || textFieldLine.contains("/") || textFieldLine.contains("*")){
           return true;
        }
        else {
           return  false;
        }
    }

    public ActionListener getCLickListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operation = e.getActionCommand();
                String txt = Calculator.textField.getText();
                String foundOperation;
                switch (operation) {
                    case "C" :
                        Calculator.textField.setText("0");
                        break;
                    case "=" :
                        if(txt.equals("0")) {
                        }
                        else {
                            if (ifExistOperation(txt)){

                            }
                            txt = Calculator.textField.getText();
                        }
                        break;
                    case "+" :
                        if (ifSecondOperation(txt)){

                        }
                        else {
                            Calculator.textField.setText(txt + operation);
                        }
                        break;
                    case "-" :
                        if(ifSecondOperation(txt)){

                        }
                        else {
                            Calculator.textField.setText(txt + operation);
                        }
                        break;
                    case "*" :
                        if(ifSecondOperation(txt)){

                        }
                        else {
                            Calculator.textField.setText(txt + operation);
                        }
                        break;
                    case "/" :
                        if(ifSecondOperation(txt)){

                        }
                        else {
                            Calculator.textField.setText(txt + operation);
                        }
                        break;
                }
            }
        };
    }
}
