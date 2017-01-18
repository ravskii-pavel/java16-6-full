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
        GridLayout gridLayout = new GridLayout(4, 3, 2, 2);

        String[] opS = {"7", "8", "9", "4", "5","6", "1", "2", "3", "0", ".", "+/-"};

        JButton button;

        for (String s : opS) {
            button = new JButton(s);
            button.setFont(new Font("",Font.PLAIN, 14));
            button.setPreferredSize(new Dimension(55, 45));
            button.addActionListener(getCLickListener());

            gridLayout.addLayoutComponent(s, button);
            add(button);
        }

        setLayout(gridLayout);
    }

    public ActionListener getCLickListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String operation = e.getActionCommand();
                String txt = Operations.isError(Calculator.textField.getText());
                String firstOperand = "";
                String secondOperand = "";
                String op = Operations.whichIsOperation(txt);
                if(Operations.isOperation(txt)){
                    firstOperand = txt.substring(0, txt.indexOf(Operations.whichIsOperation(txt)));
                    secondOperand = txt.substring(txt.indexOf(Operations.whichIsOperation(txt))+1, txt.length());
                }
                else{
                    firstOperand = txt;
                }
                switch (operation) {
                    case "+/-":
                        if ((txt.startsWith("-") && !Operations.isOperation(txt))) {
                            Calculator.textField.setText(txt.substring(1, txt.length()));
                        } else if (Operations.isOperation(txt) || txt.equals("0")) {

                        } else {
                            Calculator.textField.setText("-" + txt);
                        }
                        break;

                    case ".":
                        if ((!firstOperand.contains(".") || !txt.contains(".")) && !Operations.isOperation(txt) && secondOperand.equals("")) {
                            Calculator.textField.setText(txt + operation);
                        } else {
                            if (!secondOperand.contains(".") && !secondOperand.equals("")) {
                                Calculator.textField.setText(txt + operation);
                            }
                        }
                        break;
                    default:
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
