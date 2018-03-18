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
    public JLabel buttonDownFor;
    public JButton donateButton;
    public JLabel waitBetweenFor;
    public JSpinner minClickDelay;
    private JTabbedPane tabbedPane1;

    public JSpinner minReleaseDelay;
    public JSpinner maxClickDelay;
    public JSpinner maxReleaseDelay;

    public ClickItAuto(){
        super("Beste auto clicker ooit!");
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        changeKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.isKeyRequested = true;
                key.setText("...");
            }
        });

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        setDefaultLookAndFeelDecorated(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        pack();
    }

    private void createUIComponents() {
        SpinnerNumberModel model = new SpinnerNumberModel(100, 1, Integer.MAX_VALUE, 1);
        minClickDelay = new JSpinner(model);
        SpinnerNumberModel model1 = new SpinnerNumberModel(50, 0, Integer.MAX_VALUE, 1);
        minReleaseDelay = new JSpinner(model1);

        SpinnerNumberModel model2 = new SpinnerNumberModel(300, 1, Integer.MAX_VALUE, 1);
        maxClickDelay = new JSpinner(model2);
        SpinnerNumberModel model3 = new SpinnerNumberModel(150, 0, Integer.MAX_VALUE, 1);
        maxReleaseDelay = new JSpinner(model3);
    }
}
