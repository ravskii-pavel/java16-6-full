package calculator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by java on 27.12.2016.
 */
public class MainPanel extends JPanel {

    public MainPanel() {
        GridLayout gridLayout = new GridLayout(1, 2);

        NumberPanel numberPanel = new NumberPanel();

        gridLayout.addLayoutComponent("NumberPanel", numberPanel);
        add(numberPanel);

        OperationPanel operationPanel = new OperationPanel();

        gridLayout.addLayoutComponent("OperationPanel", operationPanel);
        add(operationPanel);



        setLayout(gridLayout);
    }
}
