package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.example.guth27.progtech.Info;

import javax.security.auth.callback.Callback;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 05. 13..
 */

public class ScreenStrings implements GameObject, IObserver {
    private String dayTime;
    private String Point;
    private String HP;
    private Paint textPaint;

    public ScreenStrings(){
        textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(50);
        textPaint.setTextAlign(Paint.Align.CENTER);

        dayTime="Day";
        HP = "30";
    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawText(Point,Info.GetScreenWidth()/2, Info.GetScreenHeight() - 20,textPaint);
        canvas.drawText(dayTime,60, Info.GetScreenHeight() - 20,textPaint);
        canvas.drawText(HP,Info.GetScreenWidth()/2, Info.GetScreenHeight() - 60,textPaint);
    }

    @Override
    public void Update() {
        Point = "Points:" + Integer.toString(Game.GetPointVolume());
        HP = "HP:" + Integer.toString(Game.GetHpVolume());
    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public String GetLabel() {
        return "StringDrawer";
    }

    @Override
    public void Start() {
        Game.RegisterToNotifier(this);
    }

    @Override
    public Point GetPosition() {
        return null;
    }

    @Override
    public boolean IsTrigger() {
        return false;
    }

    @Override
    public boolean BetweenBoundaries(int x, int y) {
        return false;
    }

    @Override
    public void ReceiveNotification(DayNight state) {
        dayTime = state.toString();
    }
}
