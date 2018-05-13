package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Balázs on 2018. 05. 10..
 */

public class NormalEnemy extends EnemyStrategy
{
    private int speed;
    private  int health;
    Paint paint;


    public NormalEnemy( int wave)
    {
        SetSpeed(5);
        CheckWave(wave);
        this.paint = new Paint();
        this.paint.setColor(Color.BLUE);
    }

    @Override
    public void SetSpeed(int speed)
    {
        this.speed=speed;
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
    public int GetReward() {
        return 5;
    }

    @Override
    public void Draw(Canvas canvas, RectF rect)
    {
        canvas.drawOval(rect,this.paint);

    }

    @Override
    public  void CheckWave(int wave)
    {
        SetHealth(10 + wave * 2);
    }

}
