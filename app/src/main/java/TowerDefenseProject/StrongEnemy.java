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

    public StrongEnemy(int speed, int wave)
    {
        SetSpeed(speed);
        CheckWave(wave);
        this.paint = new Paint(Color.CYAN);
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
        return 30;
    }

    @Override
    public void Draw(Canvas canvas, RectF rect)
    {
        canvas.drawOval(rect,this.paint);
    }

    @Override
    public void CheckWave(int wave)
    {
        if(wave<=5)
        {
            SetHealth(50);
        }
        else if (5<wave && wave<=10)
        {
            SetHealth(60);
        }
        else
        {
            SetHealth(70);
        }
    }
}
