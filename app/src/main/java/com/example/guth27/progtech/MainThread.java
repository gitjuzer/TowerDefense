package com.example.guth27.progtech;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by guth2 on 2018. 04. 22..
 */

public class MainThread extends Thread {
    public static final int MAX_FPS = Info.GetFPSrate();
    public double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;
    private static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;

        //System.out.println("update");
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }

    @Override
    public void run()
    {
        System.out.println("update");
        long startTime;
        long timeMillis;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;

        while(running)
        {
            startTime = System.nanoTime();

            try
            {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gamePanel.Update();
                    this.gamePanel.draw(canvas);
                }
            }catch(Exception e) {e.printStackTrace(); }
            finally {
                if(canvas != null)
                {
                    try{
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e) {e.printStackTrace(); }
                }
            }
            timeMillis = (System.nanoTime() - startTime)/1000000;
            waitTime = targetTime - timeMillis;
            try{
                if(waitTime > 0)
                {
                    this.sleep(waitTime);
                }
            }catch (Exception e) { e.printStackTrace(); }

            totalTime += System.nanoTime() - startTime;
            Info.SetTotalRunningTime(System.nanoTime() - startTime);
            frameCount++;
            if(frameCount == MAX_FPS)
            {
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
            }
        }
    }
}
