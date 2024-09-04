package main;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    public DisplayPanel() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100, 100, 200, 50);

    }
}
