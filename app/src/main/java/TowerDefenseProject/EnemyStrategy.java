package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Balázs on 2018. 05. 10..
 */

public abstract class EnemyStrategy
{
    /**
     * Set the speed of the enemy gameObject
     * @param speed - the speed the enemy will travel with
     */
    public abstract void SetSpeed(int speed);

    /**
     * Get the speed of the enemy gameObject
     * @return int - the speed of the enemy gameObject
     */
    public abstract int GetSpeed();

    /**
     * Set the health of the enemy gameObject
     * @param healthPoint
     */
    public  abstract void SetHealth(int healthPoint);

    /**
     * Get the remaining healthpoints of the enemy gameObject.
     * @return int - Remaining healthpoints
     */
    public  abstract int GetHealth();

    /**
     * Get the amount of gamePoints that the enemy gameObject is worth
     * @return int - the amount of gamePoints
     */
    public abstract int GetReward();

    /**
     * Draw the enemy gameObject here, using the base rectangle
     * @param canvas
     * @param rect - The base rectangle of the enemy gameObject
     */
    public  abstract void Draw(Canvas canvas, RectF rect);

    /**
     * Use this to scale the health of the enemies according to the current wave
     * @param wave - the current wave of enemies
     */
    public abstract void CheckWave(int wave);
}
