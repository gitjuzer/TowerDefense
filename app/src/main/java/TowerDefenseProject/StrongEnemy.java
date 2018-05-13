package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Balázs on 2018. 05. 10..
 */

public class StrongEnemy extends EnemyStrategy
{

    private int speed;
    private int health;
    Paint paint;

    public StrongEnemy( int wave)
    {
        SetSpeed(3);
        CheckWave(wave);
        this.paint = new Paint();
        this.paint.setColor(Color.CYAN);
    }

    @Override
    public void SetSpeed(int speed)
    {
        this.speed = speed;
    }

    @Override
    public int GetSpeed()
    {
        return this.speed;
    }

    @Override
    public void SetHealth(int healthpoint)
    {
        this.health = healthpoint;
    }

    @Override
    public int GetHealth()
    {
        return this.health;
    }

    @Override
    public int GetReward() {
        return 15;
    }

    @Override
    public void Draw(Canvas canvas, RectF rect)
    {
        canvas.drawOval(rect,this.paint);
    }

    @Override
    public void CheckWave(int wave)
    {
        if(wave < 5)
        SetHealth(20 + wave * 3);
        else if(wave < 10)
        SetHealth(40 + wave * 3);
        else if(wave < 15)
        SetHealth(60 + wave * 3);
        else if(wave < 20)
        SetHealth(80 + wave * 3);
        else if(wave < 25)
        SetHealth(100 + wave * 3);
        else if(wave < 30)
        SetHealth(150 + wave * 3);
        else if(wave < 35)
        SetHealth(200 + wave * 3);
    }
}
