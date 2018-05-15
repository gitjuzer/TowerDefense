package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public abstract class TurretState {
    /**
     * Get the amount of damage this turret can deal to enemy gameObjects
     * @param turretType - The type of turret this is attached to
     * @return int - The amount of damage this turret can deal
     */
    public abstract int GetDamage(String turretType);

    /**
     * Get the maximum range of the turret that this object is attached to.
     * @param turretType - The type of turret this is attached to
     * @return int - The maximum range of the turret
     */
    public abstract int GetRange(String turretType);

    /**
     * Use this to draw the turret gameObject
     * @param canvas
     * @param base - The base rectangle of the turret
     * @param middle - The middle rectangle of the turret
     * @param outline - The "outline" recctangle of the turret
     * @param hasoutline - Is the turret currently have outline?
     * @param turretType - the type of the turret this is attached to
     */
    public abstract void DrawTurret(Canvas canvas, Rect base, Rect middle, Rect outline, boolean hasoutline, String turretType);
}
