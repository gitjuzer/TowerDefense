package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class FastEnemy extends EnemyStrategy
{
    private int speed;
    private  int health;
    private Paint paint;

    public  FastEnemy(int wave)
    {
        SetSpeed(8);
        CheckWave(wave);
        this.paint = new Paint();
        this.paint.setColor(Color.MAGENTA);
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
    public void SetHealth(int healthPoint)
    {
        this.health = healthPoint;
    }

    @Override
    public int GetHealth()
    {
        return this.health;
    }

    @Override
    public int GetReward()
    {
        return 20;
    }

    @Override
    public void Draw(Canvas canvas, RectF rect)
    {
        canvas.drawOval(rect, this.paint);
    }

    @Override
    public void CheckWave(int wave)
    {
        if(wave < 5)
        SetHealth(10 + wave);
        else if(wave < 10)
        SetHealth(25 + wave);
        else if(wave < 15)
        SetHealth(40 + wave);
        else if(wave < 20)
        SetHealth(65 + wave);
        else if(wave < 25)
        SetHealth(90 + wave);
        else if(wave < 30)
        SetHealth(130 + wave);
        else if(wave < 35)
        SetHealth(170 + wave);
    }
}
