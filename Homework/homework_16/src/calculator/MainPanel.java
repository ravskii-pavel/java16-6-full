package calculator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ravskiy Pavel on 09.01.2017.
 */
public class MainPanel extends JPanel {

    public MainPanel() {
        GridLayout gridLayout = new GridLayout();

        NumberPanel numberPanel = new NumberPanel();
        gridLayout.addLayoutComponent("NumberPanel", numberPanel);
        add(numberPanel);

        OperationPanel operationPanel =  new OperationPanel();
        gridLayout.addLayoutComponent("NumberPanel", numberPanel);
        add(numberPanel);




    }
}
