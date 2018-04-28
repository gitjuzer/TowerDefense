package com.example.guth27.progtech;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import Interfaces.GameObject;
import Interfaces.IMovable;
import Interfaces.ISelectable;
import TowerDefenseProject.Game;

/**
 * Created by guth2 on 2018. 04. 22.
 * Responsibly for updating the game and handling user input
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private IMovable selectedIMovable;
    private boolean anObjectIsSelectedForMovement = false;
    private ISelectable selectedISelectable;

    private AbstractGame game;
    private GameObjectHolder holder;

    private int motionEventX, motionEventY;


    public GamePanel(Context context)
    {
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        holder = GameObjectHolder.GetInstance();
        game = new Game(holder);

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
        game.Start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            }catch(Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        motionEventX = (int)motionEvent.getX();
        motionEventY = (int) motionEvent.getY();
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Info.SetLastTap(motionEventX, motionEventY);

                if(holder.NumOfISelectables() != 0) {
                    ISelectable selectable = holder.GetSelectedSelectable(motionEventX, motionEventY);
                    if(selectable != null) {

                        if (selectedISelectable != null && selectedISelectable != selectable) {
                            selectedISelectable.OnUnSelected((GameObject) selectable);
                            selectable.OnSelected((GameObject) selectedISelectable);
                        }
                        else if(selectedISelectable != selectable)
                        {
                            selectable.OnSelected(null);
                        }
                        selectedISelectable = selectable;
                        Info.SetSelectedGameObject((GameObject) selectable);
                    } else if(selectedISelectable != null)
                    {
                        selectedISelectable.OnUnSelected(null);
                        selectedISelectable = null;
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                Info.SetLastTap(motionEventX, motionEventY);
                IMovable movable;
                if(!anObjectIsSelectedForMovement){
                    movable = holder.GetSelectedMovable(motionEventX, motionEventY);
                    selectedIMovable = movable;
                    anObjectIsSelectedForMovement = true;
                }else {
                    movable = selectedIMovable;
                }
                if(movable != null)
                {
                    movable.SetGameObjectPoint(motionEventX, motionEventY);
                }
                break;
            case MotionEvent.ACTION_UP:
                anObjectIsSelectedForMovement = false;
                break;
        }
        return true;
    }

    public void Update()
    {
        game.Update();
        holder.UpdateAll();
       // holder.UpdateMovables();
        holder.CheckTriggers();
    }
    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

        canvas.drawColor(Color.WHITE);
        holder.DrawAll(canvas);
       //player.Draw(canvas);
    }
}
