package ui;

import java.awt.*;

public class MenuButton {
    private int xPos, yPos, index;
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;

    public MenuButton (int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        initBounds();
    }

    private void initBounds() {
        bounds = new Rectangle(xPos, yPos, 200, 50);
    }

    public void draw(Graphics g) {
        switch (index) {
            case 0 -> {
                g.setColor(Color.lightGray);
                g.fillRect(xPos, yPos, 200, 50);
            }
            case 1 -> {
                g.setColor(Color.gray);
                g.fillRect(xPos, yPos, 200, 50);
            }
            case 2 -> {
                g.setColor(Color.darkGray);
                g.fillRect(xPos, yPos, 200, 50);
            }
        }


    }

    public void update() {
        index = 0;
        if (mouseOver) {
            index = 1;
        }
        if (mousePressed) {
            index = 2;
        }
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public void resetBools() {
        mousePressed = false;
        mouseOver = false;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
