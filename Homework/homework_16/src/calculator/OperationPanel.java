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
    public String whichIsOperation(String textFieldLine){
        char [] text = textFieldLine.toCharArray();
        if (ifSecondOperation(textFieldLine)) {
            for (int i = 0; i < text.length; i++) {
                if ((text[i] == '-' || text[i] == '+' || text[i] == '/' || text[i] == '*') && i!=0) {
                    return String.valueOf(text[i]);
                }
            }
        }
        return "operator is missing";
    }
    public boolean isDotExist(String textField){
        if(textField.contains(".")){
            return true;
        }
        return  false;
    }

    public ActionListener getCLickListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operation = e.getActionCommand();
                String txt = Calculator.textField.getText();
                String firstOperand = "";
                String secondOperand = "";
                Object firstOp;
                Object secondOp;
                if(ifSecondOperation(txt)){

                    firstOperand = txt.substring(0, txt.lastIndexOf(whichIsOperation(txt)));
                    secondOperand = txt.substring(txt.lastIndexOf(whichIsOperation(txt))+1, txt.length());
                }
                else{
                    firstOperand = txt;
                }
                String op = whichIsOperation(txt);
                switch (operation) {
                    case "C" :
                        Calculator.textField.setText("0");
                        break;
                    case "=" :
                        if(txt.equals("0")) {
                        }
                        else {
                            if (ifSecondOperation(txt) && secondOperand.equals("") == false){
                                if(isDotExist(firstOperand) || isDotExist(secondOperand)){
                                    firstOp = Double.parseDouble(firstOperand);
                                    secondOp = Double.parseDouble(secondOperand);
                                }
                                else {
                                    firstOp = Integer.parseInt(firstOperand);
                                    secondOp = Integer.parseInt(secondOperand);
                                }

                                Calculator.textField.setText(Calc.getResult(op, firstOp, secondOp));
                            }

                        }
                        break;
                    case "+" :
                        if (ifSecondOperation(txt)){

                        }
                        else {
                            if (txt.endsWith(".")){
                                txt = txt.substring(0, txt.length()-1);
                            }
                            Calculator.textField.setText(txt + operation);
                        }
                        break;
                    case "-" :
                        if(ifSecondOperation(txt)){

                        }
                        else {
                            if (txt.endsWith(".")){
                                txt = txt.substring(0, txt.length()-1);
                            }
                            Calculator.textField.setText(txt + operation);
                        }
                        break;
                    case "*" :
                        if(ifSecondOperation(txt)){

                        }
                        else {
                            if (txt.endsWith(".")){
                                txt = txt.substring(0, txt.length()-1);
                            }
                            Calculator.textField.setText(txt + operation);
                        }
                        break;
                    case "/" :
                        if(ifSecondOperation(txt)){

                        }
                        else {
                            if (txt.endsWith(".")){
                                txt = txt.substring(0, txt.length()-1);
                            }
                            Calculator.textField.setText(txt + operation);
                        }
                        break;
                }
            }
        };
    }
}
