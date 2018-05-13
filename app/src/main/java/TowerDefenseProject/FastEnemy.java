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
        return 15;
    }

    @Override
    public void Draw(Canvas canvas, RectF rect)
    {
        canvas.drawOval(rect, this.paint);
    }

    @Override
    public void CheckWave(int wave)
    {
        if(wave<=5) {
            SetHealth(10);
        }
        else if (5<wave && wave<=10) {
            SetHealth(15);
        }
        if (10<wave && wave<=15) {
            SetHealth(25);
        } else{
            SetHealth(30);
        }
    }
}
