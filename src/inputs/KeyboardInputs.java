package inputs;

import constants.constant;
import main.DisplayPanel;
import ui.RectTab;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class KeyboardInputs implements KeyListener {

    private DisplayPanel dp;

    public KeyboardInputs(DisplayPanel dp) {
        this.dp = dp;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> dp.changeYDelta(-5);
            case KeyEvent.VK_S -> dp.changeYDelta(5);
            case KeyEvent.VK_R -> System.out.println("re roll press");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {

            case KeyEvent.VK_R -> {
                dp.addTab();
            }

            case KeyEvent.VK_SPACE -> {
                for (int i = 0; i < 10; i++) {
                    dp.addTab();

                }
            }
        }
    }

}
