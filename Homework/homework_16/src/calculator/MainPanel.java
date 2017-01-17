package calculator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ravskiy Pavel on 09.01.2017.
 */
public class MainPanel extends JPanel {

    public MainPanel() {
        //GridLayout gridLayout = new GridLayout();
        //BorderLayout borderLayout = new BorderLayout();
        //borderLayout.addLayoutComponent(numberPanel, BorderLayout.WEST);
        NumberPanel numberPanel = new NumberPanel();

        //borderLayout.addLayoutComponent(numberPanel, borderLayout.CENTER);
        //numberPanel.setBorder(BorderFactory.createMatteBorder(1,2,5,1,Color.blue));
        add(numberPanel);

        OperationPanel operationPanel =  new OperationPanel();

        //borderLayout.addLayoutComponent(operationPanel, borderLayout.CENTER);
        //gridLayout.addLayoutComponent("OperationPanel", operationPanel);
        add(operationPanel);

    }
}
