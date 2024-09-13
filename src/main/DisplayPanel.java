package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import constants.constant;
import ui.RectTab;

public class DisplayPanel extends JPanel {

    private int frames = 0;
    private long lastTimeCheck = 0;
    private MouseInputs mouseInputs = new MouseInputs(this);
    private int xDelta = 100, yDelta = 100;
    private ArrayList<RectTab> tabs = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> Xs = new ArrayList<>();
    private int addAMT = 0;
    private int buffer = 28;
    //private int buffer = (int)constant.ANIM_TIME_SEC*constant.FPS_SET;
    private int pullsSinceLastSix = 0;
    private int rate = 2;


    private int Y;

    public DisplayPanel() {

        FAPAI();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    private void setPanelSize() {
        Dimension size = new Dimension(constant.RES_WIDTH, constant.RES_HEIGHT);
        setPreferredSize(size);
    }

    public void changeXDelta(int val) {
        this.xDelta += val;
    }

    public void changeYDelta(int val) {
        this.yDelta += val;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        update(g);
        //g.fillRect(xDelta, yDelta, 200, 50);
        //checkFPS();
        frames++;
    }

    private void checkFPS() {
        if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
            lastTimeCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
    }

    public void update(Graphics g) {

        for (RectTab tab : tabs) {
            tab.update(g);
        }

        if ((frames % buffer == 0) && (addAMT != 0)) {
            addTabs();
        }
    }

    public void addTab() {

        if(tabs.size() == 10) {
            tabs.clear();
            return;
        } else {
            pullsSinceLastSix++;
        }

        if (pullsSinceLastSix > 50) rate = 2 + (pullsSinceLastSix - 50) * 2;
        else rate = 2;

        System.out.println(rate);
        RectTab t = new RectTab(rate);
        if (t.isSix()) pullsSinceLastSix = 0;
        tabs.add(t);

        int i = 0;
        System.out.println(Xs.get(tabs.size() - 1));
        for (RectTab tab : tabs) {
            tab.setXPos(Xs.get(tabs.size()).get(i));
            tab.setYPos(Y);
            i++;
        }
    }

    public void addTabs() {

        int c = 10 - tabs.size();
        int i = 0;
        addTab();
        addAMT--;

    }

    public void skipToLast() {
        if(tabs.size() == 10) {
            tabs.clear();
        } else {
            addAMT = 10 - tabs.size();
        }
    }


    public void FAPAI() {

        int resX = constant.RES_WIDTH;

        int M = constant.BOX_MARGIN;
        int W = constant.BOX_WIDTH;

        Y = constant.RES_HEIGHT/2;

        for (int n = 1; n <= 11; n++) {
            ArrayList<Integer> X = new ArrayList<>();

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

            Xs.add(X);
        }


    }
}