package ui;

import java.awt.*;
import java.util.Random;
import java.util.random.*;
import constants.constant;

public class RectTab {
    private int xPos, yPos, index, w = constant.BOX_WIDTH, h = constant.BOX_HEIGHT;
    private Random random = new Random();
    private Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public RectTab () {
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(xPos - w/2, yPos - h/2, w, h);
    }

    public void update() {
    }
}
