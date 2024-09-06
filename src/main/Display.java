package main;

public class Display implements Runnable{

    private DisplayWindow dw;
    private DisplayPanel dp;
    private Thread displayThread;
    private final int FPS_SET = 144;

    public Display() {
        dp = new DisplayPanel();
        dw = new DisplayWindow(dp);
        dp.requestFocus();
        startLoop();
    }

    private void startLoop() {
        displayThread = new Thread(this);
        displayThread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1_000_000_000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        while(true) {

            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame) {
                dp.repaint();
                lastFrame = now;
            }
        }
    }
}