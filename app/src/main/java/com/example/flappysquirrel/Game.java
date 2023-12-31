package com.example.flappysquirrel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private GameLoop gameLoop;
    private Context context;

    public Game(Context context) {
        super(context);

        // Get SurfaceHolder (used to access SurfaceView) and register callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.context = context;
        this.gameLoop = new GameLoop(this, surfaceHolder); // Initialize GameLoop

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawUPS(canvas);
        drawFPS(canvas);
    }

    public void drawUPS(Canvas canvas) {
        String averageUPS = Double.toString(this.gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(this.context, R.color.magenta);
        canvas.drawText("UPS: " + averageUPS, 100, 20, paint);
    }

    public void drawFPS(Canvas canvas) {
        String averageFPS = Double.toString(this.gameLoop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(this.context, R.color.magenta);
        canvas.drawText("FPS: " + averageFPS, 100, 40, paint);
    }

    public void update() {
    }
}
