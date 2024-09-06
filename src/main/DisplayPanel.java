package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    private int frames = 0;
    private long lastTimeCheck = 0;
    private MouseInputs mouseInputs = new MouseInputs(this);
    private int xDelta = 100, yDelta = 100;
    public DisplayPanel() {

        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void changeXDelta(int val) {
        this.xDelta += val;
    }

    public void changeYDelta(int val) {
        this.yDelta += val;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        updateRect();
        g.fillRect(xDelta, yDelta, 200, 50);
        frames++;
        if(System.currentTimeMillis() - lastTimeCheck >= 1000) {
            lastTimeCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }

    }

    private void updateRect() {
        xDelta++;
        yDelta++;
    }
}
