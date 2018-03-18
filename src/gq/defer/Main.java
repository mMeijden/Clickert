package gq.defer;

import org.jnativehook.GlobalScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mega
 * Intellij IDEA
 */
@SuppressWarnings("squid:S2189")
public class Main {

    public static int keyCode = KeyEvent.VK_F8;
    public static double clicks;
    public static int clicks_done;
    public static ClickItAuto clickItAuto;
    public static boolean isKeyRequested = false;
    public static boolean keyPress = false;
    public static boolean keyActive = false;
    public static long lastTimeClicked = System.currentTimeMillis();

    public static int clickDelay = 0;
    public static int releaseDelay = 0;


    static Robot bot = null;


    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());

        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        clickItAuto = new ClickItAuto();

        while (true) {
            if (keyActive) {
                int minClickDelay = (int) clickItAuto.minClickDelay.getValue();
                int maxClickDelay = (int) clickItAuto.maxClickDelay.getValue();
                int minReleaseDelay = (int) clickItAuto.minReleaseDelay.getValue();
                int maxReleaseDelay = (int) clickItAuto.maxReleaseDelay.getValue();

                clickDelay = randomWithRange(minClickDelay, maxClickDelay);
                releaseDelay= randomWithRange(minReleaseDelay, maxReleaseDelay);

                bot.delay(clickDelay);
                bot.mousePress(InputEvent.BUTTON1_MASK);
                bot.delay(releaseDelay);
                bot.mouseRelease(InputEvent.BUTTON1_MASK);

            }

            if(clickItAuto.isActive()){
                while(clickItAuto.isActive()){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                }
            }
        }
    }

    static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
