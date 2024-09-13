package ui;

import java.awt.*;
import java.util.Random;
import java.util.random.*;
import constants.constant;

public class RectTab {
    private int xPos, yPos, index, w = constant.BOX_WIDTH, h = constant.BOX_HEIGHT;
    private Random random = new Random();
    private Color color;
    private double n;
    private String rarity;
    private int rate = 2;
    private boolean isSix = false;

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public RectTab (int rate) {
        randomizeStar();
        this.rate = rate;

    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(xPos, yPos - h/2, w, h);
        g.setColor(Color.black);
        g.drawString(rarity, xPos, yPos - h/2);
    }

    public void update(Graphics g) {
        draw(g);
    }

    public void randomizeStar() {
        n = random.nextDouble(100); //0.0 - 99.9
        int notSix = 100 - rate;
        double five =  notSix * 0.08;
        double four = notSix * 0.5;

        if (n < (rate / 2d)) {
            rarity = "6***";
            isSix = true;
            color = new Color(252, 161, 3);
        }
        else if (n < rate) {
            rarity = "6*";
            isSix = true;
            color = new Color(0, 0, 0);
        }
        else if (n < five) {
            rarity = "5*";
            color = new Color(252, 217, 61);
        }
        else if (n < four) {
            rarity = "4*";
            color = new Color(187, 100, 237);
        }
        else {
            rarity = "3*";
            color = new Color(110, 173, 255);
        }
    }

    public boolean isSix() {
        return isSix;
    }
}
