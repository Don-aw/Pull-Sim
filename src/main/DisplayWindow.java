package main;

import javax.swing.*;

public class DisplayWindow {
    private JFrame jFrame;

    public DisplayWindow(DisplayPanel dp) {
        jFrame = new JFrame();
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(dp);
        jFrame.setVisible(true);
    }
}
