import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;
import java.awt.*;

/**
 * Created by java on 27.12.2016.
 */
public class LabelPanel extends JPanel {

    public LabelPanel(){

        JLabel plainLabel = new JLabel("Plain small Label");
        add(plainLabel);

        JLabel fancyLabel = new JLabel("Fancy Big Label");

        Font fancyFont = new Font("Serif", Font.BOLD | Font.ITALIC, 32);

        fancyLabel.setFont(fancyFont);
        //Icon folderIcon = new ImageIcon("animated-tiger-gif-1.gif");
        Icon folderIcon = new MetalIconFactory.TreeFolderIcon();
                // = new ImageIcon("SmallTiger.gif");


        fancyLabel.setIcon(folderIcon);
        fancyLabel.setHorizontalAlignment(JLabel.RIGHT);

        add(fancyLabel);
    }

}
