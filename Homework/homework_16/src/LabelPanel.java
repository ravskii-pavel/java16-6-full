import javax.swing.*;
import java.awt.*;

/**
 * Created by Ravskiy Pavel on 09.01.2017.
 */
public class LabelPanel extends JPanel {
    public LabelPanel() {
        JLabel plainLabel = new JLabel("Plain small label");
        add(plainLabel);

        JLabel fancyLabel = new JLabel("Fancy Big label");
        Font font = new Font("Serif", Font.BOLD | Font.ITALIC, 32);

        fancyLabel.setFont(font);

//        Icon folderIcon = new ImageIcon("sw.gif");
//        fancyLabel.setIcon(folderIcon);

        fancyLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(fancyLabel);
    }
}
