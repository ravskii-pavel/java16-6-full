package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.Arrays;

/**
 * Created by Ravskiy Pavel on 09.01.2017.
 */
public class NumberPanel extends JPanel{
    public NumberPanel() {
        GridLayout gridLayout = new GridLayout(4, 3, 4, 4);

        String[] opS = {"7", "8", "9", "4", "5","6", "1", "2", "3", "0", ".", "+/-"};

        JButton button;

        for (String s : opS) {
            button = new JButton(s);
            button.setPreferredSize(new Dimension(50, 45));
            button.addActionListener(getCLickListener());

            gridLayout.addLayoutComponent(s, button);
            add(button);
        }

        setLayout(gridLayout);
    }
    public boolean isDotExist(String textField){
        if(textField.contains(".")){
            return true;
        }
        return  false;
    }
    public String whichIsOperation(String textFieldLine){
        char [] text = textFieldLine.toCharArray();
        if (isOperation(textFieldLine)) {
            for (int i = 0; i < text.length; i++) {
                if (text[i] == '-' || text[i] == '+' || text[i] == '/' || text[i] == '*' && i!=0) {
                    return String.valueOf(text[i]);
                }
            }
        }
        return "operator is missing";
    }

    public boolean isOperation(String textFieldLine){
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
                String firstOperand = "";
                String secondOperand = "";
                if(isOperation(txt)){
                    firstOperand = txt.substring(0, txt.indexOf(whichIsOperation(txt)));
                    secondOperand = txt.substring(txt.indexOf(whichIsOperation(txt))+1, txt.length());
                }
                else{
                    firstOperand = txt;
                }
                switch (operation) {
                    case "+/-":
                        if ((txt.startsWith("-") && !isOperation(txt))) {
                            Calculator.textField.setText(txt.substring(1, txt.length()));
                        } else if (isOperation(txt) || txt.equals("0")) {

                        } else {
                            Calculator.textField.setText("-" + txt);
                        }
                        break;

                    case ".":
                        if ((!firstOperand.contains(".") || !txt.contains(".")) && !isOperation(txt) && secondOperand.equals("")) {
                            Calculator.textField.setText(txt + operation);
                        } else {
                            if (!secondOperand.contains(".") && !secondOperand.equals("")) {    //!txt.contains(".") && !isOperation(txt)
                                Calculator.textField.setText(txt + operation);
                            }
                        }
                        break;
                    case "0":
                        if (txt.equals("0") || secondOperand.equals("0")) {

                        } else {
                            Calculator.textField.setText(txt + operation);
                        }
                        break;
                    default:
                        String op = whichIsOperation(txt);
                        if (txt.equals("0")) {
                            Calculator.textField.setText("");
                        }
                        if (!txt.substring(txt.length() - 1, txt.length() - 1).equals(op) && !secondOperand.equals("0")) {
                            txt = Calculator.textField.getText();
                            Calculator.textField.setText(txt + operation);
                        }
                }
            }
        };
    }
}
