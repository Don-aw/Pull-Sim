package inputs;

import constants.constant;
import main.DisplayPanel;
import ui.RectTab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class KeyboardInputs implements KeyListener {

    private ArrayList<Integer> X = new ArrayList<>();
    private int Y;

    private DisplayPanel dp;
    private ArrayList<RectTab> tabs = new ArrayList<>();

    public KeyboardInputs(DisplayPanel dp) {
        this.dp = dp;
        FAPAI();
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
                int i = 0;
                    for (RectTab tab : tabs) {
                        tab.setXPos(X.get(i));
                        tab.setYPos(Y);
                        i++;
                    }
                update();
            }
        }
    }

    public void update() {
        for (RectTab tab : tabs) {
            tab.update();
        }
    }

    public void FAPAI() {

        int resX = constant.RES_WIDTH;

        int M = constant.BOX_MARGIN;
        int W = constant.BOX_WIDTH;

        Y = constant.RES_HEIGHT/2;

        for (int n = 1; n <= 9; n++) {

            if (n % 2 != 0) {

                X.add(resX / 2);

                for (int i = 1; i < (n + 1) / 2; i++) {
                    X.addFirst(resX / 2 - i * M - i * W);
                    X.addLast(resX / 2 + i * M + i * W);
                }
            }
            else {

                for (int i = 0; i < n/2; i++) {
                    X.addFirst(resX/2 - M/2 - W/2 - i*M - i*W);
                    X.addLast(resX/2 + M/2 + W/2 + i*M + i*W);
                }
            }
        }
    }
}
