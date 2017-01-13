package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ravskiy Pavel on 09.01.2017.
 */
public class NumberPanel extends JPanel{
    public NumberPanel() {
        GridLayout gridLayout = new GridLayout(4, 3, 4, 4);

        String[] opS = {"7", "8", "9", "4", "5","6", "1", "2", "3", "0", "."};

        JButton button;

        for (String s : opS) {
            button = new JButton(s);
            button.setPreferredSize(new Dimension(45, 40));
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

                if(Calculator.textField.getText().equals("0")) {
                    Calculator.textField.setText("");
                }
                if(e.getActionCommand().equals(".")) {

                }
                else {
                    String txt = Calculator.textField.getText();
                    Calculator.textField.setText(txt + e.getActionCommand());
                }

            }

        };
    }
}
