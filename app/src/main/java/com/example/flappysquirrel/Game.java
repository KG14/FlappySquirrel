package com.example.flappysquirrel;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    public Game(Context context) {
        super(context);

        // Get SurfaceHolder (used to access SurfaceView) and register callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        GameLoop gameLoop = new GameLoop(this, surfaceHolder); // Initialize GameLoop
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
