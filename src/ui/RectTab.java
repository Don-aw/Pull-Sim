package ui;

import java.awt.*;
import java.util.Random;
import java.util.random.*;
import constants.constant;

public class RectTab {
    private int xPos, yPos, index, w = constant.BOX_WIDTH, h = constant.BOX_HEIGHT;
    private Random random = new Random();
    private Color color;
    private int n;
    private String rarity;

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public RectTab () {
        randomizeStar();
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
        n = random.nextInt(100);

        if (n == 0) {
            rarity = "6***";
            color = new Color(252, 161, 3);
        }
        else if (n == 1) {
            rarity = "6*";
            color = new Color(0, 0, 0);
        }
        else if (n <= 10) {
            rarity = "5*";
            color = new Color(252, 217, 61);
        }
        else if (n <= 60) {
            rarity = "4*";
            color = new Color(187, 100, 237);
        }
        else {
            rarity = "3*";
            color = new Color(110, 173, 255);
        }
    }
}
