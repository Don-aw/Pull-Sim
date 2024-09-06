package inputs;

import main.DisplayPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;

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

            case KeyEvent.VK_R -> System.out.println("re roll release");
        }
    }
}
