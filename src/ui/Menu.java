package ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Menu {

    private MenuButton button = new MenuButton(100, 100);

    public Menu() {
    }

    public void update() {
        button.update();
    }

    public void draw(Graphics g) {
        button.draw(g);
    }

    public void mousePressed(MouseEvent e) {
        if(isIn(e, button)) {
            button.setMousePressed(true);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if(isIn(e, button)) {
            if(button.isMousePressed()) {

            }
        }
        button.resetBools();
    }

    public void mouseMoved(MouseEvent e) {
        button.setMouseOver(false);
        if (isIn(e, button)) {
            button.setMouseOver(true);
        }
    }

    public boolean isIn(MouseEvent e, MenuButton mb) {
        return mb.getBounds().contains(e.getX(), e.getY());
    }
}
