package gq.defer;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.KeyEvent;

/**
 * Created by WB71LR
 * Intellij IDEA
 */
public class GlobalKeyListener implements NativeKeyListener {

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {

        if (Main.isKeyRequested) {
            Main.clickItAuto.key.setText(KeyEvent.getKeyText(nativeEvent.getRawCode()));
            Main.keyCode = nativeEvent.getRawCode();
            Main.isKeyRequested = false;
        }

        if (nativeEvent.getRawCode() == Main.keyCode) {
            Main.keyActive = !Main.keyActive;
        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
        if (nativeEvent.getRawCode() == Main.keyCode) {
            Main.keyPress = false;
        }
    }
}
