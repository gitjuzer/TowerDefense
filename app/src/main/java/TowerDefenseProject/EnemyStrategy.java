package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Balázs on 2018. 05. 10..
 */

public abstract class EnemyStrategy
{
    public abstract void SetSpeed(int speed);
    public abstract int GetSpeed();
    public  abstract void SetHealth(int healthPoint);
    public  abstract int GetHealth();
    public abstract int GetReward();
    public  abstract void Draw(Canvas canvas, RectF rect);
    public abstract void CheckWave(int wave);
}
