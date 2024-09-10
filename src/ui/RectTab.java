package ui;

import java.awt.*;
import java.util.Random;
import java.util.random.*;
import constants.constant;

public class RectTab {
    private int xPos, yPos, index, w = constant.BOX_WIDTH, h = constant.BOX_HEIGHT;
    private Random random = new Random();
    private Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    private int n, rarity;

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
        g.drawString(rarity + "", xPos, yPos - h/2);
    }

    public void update(Graphics g) {
        draw(g);
    }

    public void randomizeStar() {
        n = random.nextInt(100);
        //rarity = n;
        //add assign here
    }

}
