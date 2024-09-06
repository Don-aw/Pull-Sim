package main;

public class Display {

    private DisplayWindow dw;
    private DisplayPanel dp;

    public Display() {
        dp = new DisplayPanel();
        dw = new DisplayWindow(dp);
        dp.requestFocus();
    }
}