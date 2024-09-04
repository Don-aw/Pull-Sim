package main;

import javax.swing.*;

public class DisplayWindow {
    private JFrame jFrame;

    public DisplayWindow() {
        jFrame = new JFrame();

        jFrame.setSize(400, 400);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setVisible(true);
    }
}
