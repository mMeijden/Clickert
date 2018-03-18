package gq.defer;

import org.jnativehook.GlobalScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by WB71LR
 * Intellij IDEA
 */
@SuppressWarnings("squid:S2189")
public class Main {

    public static int keyCode = KeyEvent.VK_F8;
    public static ClickItAuto clickItAuto;
    public static boolean isKeyRequested = false;
    public static boolean keyPress = false;
    public static boolean keyActive = false;


    public static void main(String[] args) {
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        Robot bot = null;
        try {
            GlobalScreen.registerNativeHook();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            bot = new Robot();
        } catch (Exception e) {
            //  logger.info(e.toString());
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());

        clickItAuto = new ClickItAuto();

        while (true) {
            if (clickItAuto.isActive()) {
                keyActive = false;
            }

            if (keyActive) {
                int minClickDelay = Integer.parseInt(clickItAuto.minClickDelay.getText());
                int maxClickDelay = Integer.parseInt(clickItAuto.maxClickDelay.getText());

                int minReleaseDelay = Integer.parseInt(clickItAuto.minReleaseDelay.getText());
                int maxReleaseDelay = Integer.parseInt(clickItAuto.maxReleaseDelay.getText());

                int clickDelay = randomWithRange(minClickDelay, maxClickDelay);
                int releaseDelay = randomWithRange(minReleaseDelay, maxReleaseDelay);

                handleEvent(clickDelay, releaseDelay, bot);

            }

        }
    }

    private static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    private static void handleEvent(int clickDelay, int releaseDelay, Robot bot) {
        if (null != bot) {
            bot.delay(clickDelay);
            bot.mousePress(InputEvent.BUTTON1_MASK);
            bot.delay(releaseDelay);
            bot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
    }
}
