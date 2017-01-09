import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("My title");
        //frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new LabelPanel());
        BorderLayout layout = new BorderLayout();

        LabelPanel labelPanel = new LabelPanel();

        Menu menu = new Menu();

        layout.addLayoutComponent(menu, BorderLayout.PAGE_START);
        //layout.addLayoutComponent(labelPanel, BorderLayout.CENTER);
        frame.setLayout(layout);

        frame.add(menu);
        //frame.add(labelPanel);

        JLabel label = new JLabel ();
        label.setText("0");

            layout.addLayoutComponent(label,BorderLayout.LINE_START);
            frame.add(label);
        JButton button = new JButton("Click");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Clicked has been done");
                label.setText((++counter) + "");
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(40, 25));
        btnPanel.add(button);

        /*button.setPreferredSize(new Dimension(100, 100));
        frame.add(button);*/

        layout.addLayoutComponent(btnPanel, BorderLayout.CENTER);

        frame.add(btnPanel);

        frame.setLayout(layout);
        frame.setVisible(true);






        /*Thread.sleep(2000);
        frame.setState(Frame.ICONIFIED);
        Thread.sleep(2000);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        Thread.sleep(2000);
        frame.setExtendedState(Frame.NORMAL);*/

    }
}
