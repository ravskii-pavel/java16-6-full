import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;
import java.awt.*;

/**
 * Created by java on 27.12.2016.
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
