package inputs;

import constants.constant;
import main.DisplayPanel;
import ui.RectTab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class KeyboardInputs implements KeyListener {

    private DisplayPanel dp;
    private ArrayList<RectTab> tabs = new ArrayList<>();

    public KeyboardInputs(DisplayPanel dp) {
        this.dp = dp;
    }

    public void addTab(RectTab tab) {
        tabs.add(tab);
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
                addTab(new RectTab());
                boolean isEven = tabs.size() % 2 == 0;
                if (isEven)
                for (RectTab tab : tabs) {
                    tab.setXPos((constant.RES_WIDTH / 2));
                    tab.setYPos(constant.RES_HEIGHT / 2);
                    i++;
                }
                update();
            }
        }
    }

    public void update() {
        for (RectTab tab : tabs) {

        }
    }
}
