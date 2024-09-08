package main;

import javax.swing.*;

public class DisplayWindow {
    private JFrame jFrame;

    public DisplayWindow(DisplayPanel dp) {
        jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(dp);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
