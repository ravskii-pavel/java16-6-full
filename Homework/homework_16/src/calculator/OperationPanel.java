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
        GridLayout gridLayout = new GridLayout(3, 2, 2, 2);

        String[] opS = {"/", "*", "+", "-", "=", "C"};

        JButton button;
        for (String s : opS) {
            button = new JButton(s);
            button.setFont(new Font("",Font.PLAIN, 20));
            button.setPreferredSize(new Dimension(50, 60));
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
                String txt = Calculator.textField.getText();
                String result="";
                txt = Operations.isError(txt);

                switch (operation) {
                    case "C" :
                        Calculator.textField.setText("0");
                        break;
                    case "=" :
                        Operations.result(txt);
                        break;
                    case "+" :
                        Operations.resultAndSecondOperation(txt, operation);
                        break;
                    case "-" :
                        Operations.resultAndSecondOperation(txt, operation);
                        break;
                    case "*" :
                        Operations.resultAndSecondOperation(txt, operation);
                        break;
                    case "/" :
                        Operations.resultAndSecondOperation(txt, operation);
                        break;
                }
            }
        };
    }
}
