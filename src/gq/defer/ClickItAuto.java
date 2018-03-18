package gq.defer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mega
 * Intellij IDEA
 */
public class ClickItAuto extends JFrame{

    public JButton changeKeyButton;
    public JPanel panel;
    public JLabel key;
    public JLabel waitBetweenFor;
    private JTabbedPane tabbedPane1;

    public JTextField minClickDelay;
    public JTextField maxClickDelay;
    public JTextField minReleaseDelay;
    public JTextField maxReleaseDelay;



    public ClickItAuto(){
        super("Beste auto clicker ooit!");
        setContentPane(panel);
        pack();

        changeKeyButton.addActionListener(e -> {
            Main.isKeyRequested = true;
            key.setText("...");
        });

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        setDefaultLookAndFeelDecorated(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        pack();
    }
}
