package com.example.flappysquirrel;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameLoop extends Thread {
    private boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    private Game game;

    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        this.game = game;
    }

    public double getAverageUPS() {
        return 0;
    }

    public double getAverageFPS() {
        return 0;
    }

    public void startLoop() {
        this.isRunning = true;
        start();
    }

    @Override
    public void run() {
        super.run();

        // Game Loop
        Canvas canvas;
        while(isRunning) {

            // Update and render game
            try {
                canvas = this.surfaceHolder.lockCanvas(); // Locks and gets associated Canvas object
                game.update();
                game.draw(canvas);
            } catch (IllegalArgumentException e) { // In case Canvas already locked by another method
                e.printStackTrace();
            }
        }
    }
}
